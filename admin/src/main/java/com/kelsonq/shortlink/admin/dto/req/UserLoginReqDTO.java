package com.kelsonq.shortlink.admin.dto.req;

import lombok.Data;

@Data
public class UserLoginReqDTO {

  /**
   * User name
   */
  private String username;
  /**
   * Password
   */
  private String password;
}
