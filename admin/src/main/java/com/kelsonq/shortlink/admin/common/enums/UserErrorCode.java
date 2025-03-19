package com.kelsonq.shortlink.admin.common.enums;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;

public enum UserErrorCode implements IErrorCode {
  USER_NOT_FOUND("B000200", "User not found");

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
