package com.kelsonq.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kelsonq.shortlink.admin.dao.entity.UserDO;
import com.kelsonq.shortlink.admin.dto.req.UserRegisterReqDTO;
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

  /**
   * Check if the username exists
   *
   * @param username username
   * @return true if the username exists
   */

  Boolean validUsername(String username);

  /**
   * Register user
   *
   * @param registerReqParam user register request data transfer object
   */
  void registerUser(UserRegisterReqDTO registerReqParam);
}
