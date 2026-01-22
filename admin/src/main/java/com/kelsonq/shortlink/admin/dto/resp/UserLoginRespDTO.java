package com.kelsonq.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User login response
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRespDTO {

  /**
   * User Token
   */
  private String token;
}
