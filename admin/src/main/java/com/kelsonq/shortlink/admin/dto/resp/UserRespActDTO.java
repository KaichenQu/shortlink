package com.kelsonq.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * User response data transfer object
 */
@Data
public class UserRespActDTO {

  /**
   * ID
   */
  private Long id;

  /**
   * Username
   */
  private String username;


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
