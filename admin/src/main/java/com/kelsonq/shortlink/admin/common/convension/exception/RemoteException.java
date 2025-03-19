package com.kelsonq.shortlink.admin.common.convension.exception;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.BaseErrorCode;
import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;

public class RemoteException extends AbstractException {

  public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
    super(message, throwable, errorCode);
  }

  public RemoteException(IErrorCode errorCode) {
    this(null, null, errorCode);
  }

  public RemoteException(String message) {
    this(message, null, BaseErrorCode.REMOTE_ERROR);
  }

  public RemoteException(String message, IErrorCode errorCode) {
    this(message, null, errorCode);
  }

  @Override
  public String toString() {
    return "RemoteException{" +
        "code='" + errorCode + "'," +
        "message='" + errorMessage + "'" +
        '}';
  }
}
