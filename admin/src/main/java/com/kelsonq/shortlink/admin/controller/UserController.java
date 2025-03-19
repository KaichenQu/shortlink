package com.kelsonq.shortlink.admin.controller;

import com.kelsonq.shortlink.admin.common.convension.result.Result;
import com.kelsonq.shortlink.admin.common.convension.result.Results;
import com.kelsonq.shortlink.admin.dto.resp.UserRespDTO;
import com.kelsonq.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * user control class
 */
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  /**
   * get user by username
   */
  @GetMapping("/api/shortlink/admin/v1/user/{username}")
  public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
    return Results.success(userService.getUserByUsername(username));
  }
}
