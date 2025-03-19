package com.kelsonq.shortlink.admin.common.convension.exception;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.BaseErrorCode;
import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;

/**
 * Client Exceptions
 */
public class ClientException extends AbstractException {

  public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
    super(message, throwable, errorCode);
  }

  public ClientException(IErrorCode errorCode) {
    this(null, null, errorCode);
  }

  public ClientException(String message) {
    this(message, null, BaseErrorCode.CLIENT_ERROR);
  }

  public ClientException(String message, IErrorCode errorCode) {
    this(message, null, errorCode);
  }


  @Override
  public String toString() {
    return "ClientException{" +
        "code='" + errorCode + "'," +
        "message='" + errorMessage + "'" +
        '}';
  }
}
