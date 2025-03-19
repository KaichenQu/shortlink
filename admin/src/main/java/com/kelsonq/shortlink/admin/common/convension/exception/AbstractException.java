package com.kelsonq.shortlink.admin.common.convension.exception;

import com.kelsonq.shortlink.admin.common.convension.IErrorCode.IErrorCode;
import java.util.Optional;
import lombok.Getter;
import org.springframework.util.StringUtils;

/**
 * Abstract Exception: ClientException, ServiceException, RemoteException
 *
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 */
@Getter
public abstract class AbstractException extends RuntimeException {

  public final String errorCode;

  public final String errorMessage;

  public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
    super(message, throwable);
    this.errorCode = errorCode.code();
    this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
  }
}