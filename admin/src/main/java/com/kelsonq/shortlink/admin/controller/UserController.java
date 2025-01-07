package com.kelsonq.shortlink.admin.controller;

import com.kelsonq.shortlink.admin.dto.resp.UserRespDTO;
import com.kelsonq.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *  user control class
 */
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  /**
   *  get user by username
   */

  @GetMapping("/api/shortlink/v1/user/{username}")
  public UserRespDTO getUserByUsername(@PathVariable("username") String username) {
    return userService.getUserByUsername(username);
  }
}
