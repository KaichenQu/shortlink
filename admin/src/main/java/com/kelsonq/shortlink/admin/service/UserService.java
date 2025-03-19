package com.kelsonq.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kelsonq.shortlink.admin.dao.entity.UserDO;
import com.kelsonq.shortlink.admin.dto.resp.UserRespDTO;

/**
 * User Service
 */
public interface UserService extends IService<UserDO> {

  /**
   * Get user by username
   *
   * @param username username
   * @return user response data transfer object
   */
  UserRespDTO getUserByUsername(String username);
}
