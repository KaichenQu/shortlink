package com.kelsonq.shortlink.admin.common.convension.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * Response Result
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * Code for success
   */
  public static final String SUCCESS_CODE = "0";

  /**
   * Code for failure
   */
  private String code;

  /**
   * Message
   */
  private String message;

  /**
   * Message Data
   */
  private T data;

  /**
   * Request ID
   */
  private String requestId;

  public boolean isSuccess() {
    return SUCCESS_CODE.equals(code);
  }
}