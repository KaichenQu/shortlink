package com.kelsonq.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kelsonq.shortlink.admin.common.convension.exception.ClientException;
import com.kelsonq.shortlink.admin.common.enums.UserErrorCode;
import com.kelsonq.shortlink.admin.dao.entity.UserDO;
import com.kelsonq.shortlink.admin.dao.mapper.UserMapper;
import com.kelsonq.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.kelsonq.shortlink.admin.dto.resp.UserRespDTO;
import com.kelsonq.shortlink.admin.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * User Service Implementation
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

  private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
  private final RedissonClient redissonClient;


  @Override
  public UserRespDTO getUserByUsername(String username) {
    LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
        .eq(UserDO::getUsername, username);
    return Optional.ofNullable(baseMapper.selectOne(queryWrapper)).map(userDO -> {
          UserRespDTO result = new UserRespDTO();
          BeanUtils.copyProperties(userDO, result);
          return result;
        })
        .orElseThrow(() -> new ClientException(UserErrorCode.USER_NOT_FOUND));
  }

  @Override
  public Boolean validUsername(String username) {
    return !userRegisterCachePenetrationBloomFilter.contains(username);
  }

  @Override
  public void registerUser(UserRegisterReqDTO registerReqParam) {
    RRateLimiter rateLimiter = redissonClient.getRateLimiter("RATE_LIMITER_USER_REGISTER_KEY" + registerReqParam.getUsername());
    rateLimiter.trySetRate(RateType.OVERALL, 1, 10, RateIntervalUnit.SECONDS);
    if (!rateLimiter.tryAcquire()) {
      throw new ClientException(UserErrorCode.USER_FREQUENTLY);
    }

    if (!validUsername(registerReqParam.getUsername())) {
      throw new ClientException(UserErrorCode.USER_NAME_EXISTS);
    }
    RLock lockUserRegisterKey = redissonClient.getLock("LOCK_USER_REGISTER_KEY" + registerReqParam.getUsername());
    try {
      if (lockUserRegisterKey.tryLock()) {
        int insert = baseMapper.insert(BeanUtil.toBean(registerReqParam, UserDO.class));
        if (insert < 1) {
          throw new ClientException(UserErrorCode.USER_SAVE_ERROR);
        }
        userRegisterCachePenetrationBloomFilter.add(registerReqParam.getUsername());
        return;
      }
      throw new ClientException(UserErrorCode.USER_EXISTS);
    } finally {
      lockUserRegisterKey.unlock();
    }
  }
}

