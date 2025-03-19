package com.kelsonq.shortlink.admin.common.web;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.kelsonq.shortlink.admin.common.convension.IErrorCode.BaseErrorCode;
import com.kelsonq.shortlink.admin.common.convension.exception.AbstractException;
import com.kelsonq.shortlink.admin.common.convension.result.Result;
import com.kelsonq.shortlink.admin.common.convension.result.Results;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler
 *
 */
@Component
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Intercepting parameter validation exceptions
   */
  @SneakyThrows
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public Result<Void> validExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    FieldError firstFieldError = CollectionUtil.getFirst(bindingResult.getFieldErrors());
    String exceptionStr = Optional.ofNullable(firstFieldError)
        .map(FieldError::getDefaultMessage)
        .orElse(StrUtil.EMPTY);
    log.error("[{}] {} [ex] {}", request.getMethod(), getUrl(request), exceptionStr);
    return Results.failure(BaseErrorCode.CLIENT_ERROR.code(), exceptionStr);
  }

  /**
   * Intercepting exceptions thrown within the application
   */
  @ExceptionHandler(value = {AbstractException.class})
  public Result abstractException(HttpServletRequest request, AbstractException ex) {
    if (ex.getCause() != null) {
      log.error("[{}] {} [ex] {}", request.getMethod(), request.getRequestURL().toString(), ex.toString(), ex.getCause());
      return Results.failure(ex);
    }
    log.error("[{}] {} [ex] {}", request.getMethod(), request.getRequestURL().toString(), ex.toString());
    return Results.failure(ex);
  }

  /**
   * Intercepting all exceptions
   */
  @ExceptionHandler(value = Throwable.class)
  public Result defaultErrorHandler(HttpServletRequest request, Throwable throwable) {
    log.error("[{}] {} ", request.getMethod(), getUrl(request), throwable);
    return Results.failure();
  }

  private String getUrl(HttpServletRequest request) {
    if (StringUtils.isEmpty(request.getQueryString())) {
      return request.getRequestURL().toString();
    }
    return request.getRequestURL().toString() + "?" + request.getQueryString();
  }
}
