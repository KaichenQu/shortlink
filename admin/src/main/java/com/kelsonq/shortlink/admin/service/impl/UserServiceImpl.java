package com.kelsonq.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kelsonq.shortlink.admin.common.convension.exception.ClientException;
import com.kelsonq.shortlink.admin.common.enums.UserErrorCode;
import com.kelsonq.shortlink.admin.dao.entity.UserDO;
import com.kelsonq.shortlink.admin.dao.mapper.UserMapper;
import com.kelsonq.shortlink.admin.dto.resp.UserRespDTO;
import com.kelsonq.shortlink.admin.service.UserService;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * User Service Implementation
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

  @Override
  public UserRespDTO getUserByUsername(String username) {
    if (username == null) {
      return null;
    }
    LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
        .eq(UserDO::getUsername, username);
    return Optional.ofNullable(baseMapper.selectOne(queryWrapper)).map(userDO -> {
          UserRespDTO result = new UserRespDTO();
          BeanUtils.copyProperties(userDO, result);
          return result;
        })
        .orElseThrow(() -> new ClientException(UserErrorCode.USER_NOT_FOUND));
  }
}

