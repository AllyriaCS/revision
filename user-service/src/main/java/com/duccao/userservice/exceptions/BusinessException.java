package com.duccao.userservice.exceptions;

public class BusinessException extends RuntimeException {

  private final BusinessError error;

  public BusinessException(BusinessError error) {
    super();
    this.error = error;
  }

  public BusinessException(String message, BusinessError error) {
    super(message);
    this.error = error;
  }

  public BusinessException(String message, Throwable cause, BusinessError error) {
    super(message, cause);
    this.error = error;
  }

  public BusinessException(Throwable cause, BusinessError error) {
    super(cause);
    this.error = error;
  }

  public BusinessError getError() {
    return error;
  }
}
