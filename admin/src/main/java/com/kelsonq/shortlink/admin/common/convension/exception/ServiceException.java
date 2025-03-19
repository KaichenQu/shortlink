package com.kelsonq.shortlink.admin.common.convension.exception;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.BaseErrorCode;
import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;
import java.util.Optional;

public class ServiceException extends AbstractException {

  public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
    super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
  }

  public ServiceException(String message) {
    this(message, null, BaseErrorCode.SERVICE_ERROR);
  }

  public ServiceException(IErrorCode errorCode) {
    this(null, errorCode);
  }

  public ServiceException(String message, IErrorCode errorCode) {
    this(message, null, errorCode);
  }


  @Override
  public String toString() {
    return "ServiceException{" +
        "code='" + errorCode + "'," +
        "message='" + errorMessage + "'" +
        '}';
  }

}
