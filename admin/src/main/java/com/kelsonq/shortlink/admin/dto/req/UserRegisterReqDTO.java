package com.kelsonq.shortlink.admin.dto.req;

import lombok.Data;

/**
 * User Register Request Data Transfer Object
 */
@Data
public class UserRegisterReqDTO {

  /**
   * Username
   */
  private String username;

  /**
   * Password
   */
  private String password;

  /**
   * Real Name
   */
  private String realName;

  /**
   * Mobile Phone
   */
  private String phone;

  /**
   * Mail
   */
  private String mail;
}
