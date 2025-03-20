package com.kelsonq.shortlink.admin.common.enums;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;

public enum UserErrorCode implements IErrorCode {
  USER_NOT_FOUND("B000200", "User not found"),
  USER_NAME_EXISTS("B000201", "Username already exists"),
  USER_EXISTS("B000202", "User already exists"),
  USER_SAVE_ERROR("B000203", "Failed to save user information"),
  USER_FREQUENTLY("B000204", "User registration is too frequent");

  private final String code;

  private final String message;

  UserErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String code() {
    return code;
  }

  @Override
  public String message() {
    return message;
  }
}
