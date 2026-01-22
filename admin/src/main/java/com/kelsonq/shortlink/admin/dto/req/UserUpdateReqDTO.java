package com.kelsonq.shortlink.admin.dto.req;

import lombok.Data;

@Data
public class UserUpdateReqDTO {

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
