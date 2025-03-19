package com.kelsonq.shortlink.admin.common.convension.IErrorCode;

/**
 * Base error code
 */
public enum BaseErrorCode implements IErrorCode {

  // ========== Tier 1 Code General Error ==========
  CLIENT_ERROR("A000001", "Client Error"),

  // ========== Tier 2 Code User Register Error ==========
  USER_REGISTER_ERROR("A000100", "User Register Error"),
  USER_NAME_VERIFY_ERROR("A000110", "Username Verify Error"),
  USER_NAME_EXIST_ERROR("A000111", "Username Already Exist"),
  USER_NAME_SENSITIVE_ERROR("A000112", "Username Sensitive"),
  USER_NAME_SPECIAL_CHARACTER_ERROR("A000113", "Username Special Character"),
  PASSWORD_VERIFY_ERROR("A000120", "Password Verify Error"),
  PASSWORD_SHORT_ERROR("A000121", "Password Too Short"),
  PHONE_VERIFY_ERROR("A000151", "Phone Verify Error"),

    // ========== Tier 2 Code User Login Error ==========
  IDEMPOTENT_TOKEN_NULL_ERROR("A000200", "Idempotent Token empty"),
  IDEMPOTENT_TOKEN_DELETE_ERROR("A000201", "Idempotent Token delete error"),

  // ========== Tier 1 Code System Error ==========
  SERVICE_ERROR("B000001", "Service Error"),
  // ========== Tier 2 Code System Timeout Error ==========
  SERVICE_TIMEOUT_ERROR("B000100", "Service Timeout"),

  // ========== Tier 1 Code Remote Error ==========
  REMOTE_ERROR("C000001", "Remote Error"),;

  private final String code;

  private final String message;

  BaseErrorCode(String code, String message) {
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
