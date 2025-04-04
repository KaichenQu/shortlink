package com.kelsonq.shortlink.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kelsonq.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * User response data transfer object
 */
@Data
public class UserRespDTO {
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
  @JsonSerialize(using = PhoneDesensitizationSerializer.class)
  private String phone;

  /**
   * Mail
   */
  private String mail;

}
