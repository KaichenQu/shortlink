package com.kelsonq.shortlink.admin.common.convension.result;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.BaseErrorCode;
import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;
import com.kelsonq.shortlink.admin.common.convension.exception.AbstractException;
import java.util.Optional;

public final class Results {

  /**
   * Success response without data
   */
  public static Result<Void> success() {
    return new Result<Void>()
        .setCode(Result.SUCCESS_CODE);
  }

  /**
   * Success response with data
   */
  public static <T> Result<T> success(T data) {
    return new Result<T>()
        .setCode(Result.SUCCESS_CODE)
        .setData(data);
  }

  /**
   * Failure response without data
   */
  public static Result<Void> failure() {
    return new Result<Void>()
        .setCode(BaseErrorCode.SERVICE_ERROR.code())
        .setMessage(BaseErrorCode.SERVICE_ERROR.message());
  }

  /**
   * Failure response with {@link AbstractException}
   */
  public static Result<Void> failure(AbstractException abstractException) {
    String errorCode = Optional.ofNullable(abstractException.getErrorCode())
        .orElse(BaseErrorCode.SERVICE_ERROR.code());
    String errorMessage = Optional.ofNullable(abstractException.getErrorMessage())
        .orElse(BaseErrorCode.SERVICE_ERROR.message());
    return new Result<Void>()
        .setCode(errorCode)
        .setMessage(errorMessage);
  }

  /**
   * Failure response with error code and error message
   */
  public static Result<Void> failure(String errorCode, String errorMessage) {
    return new Result<Void>()
        .setCode(errorCode)
        .setMessage(errorMessage);
  }
  public static Result<Void> failure(IErrorCode errorCode) {
    return new Result<Void>()
        .setCode(errorCode.code())
        .setMessage(errorCode.message());
  }
}