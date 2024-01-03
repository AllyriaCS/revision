package com.duccao.userservice.exceptions;

public enum TechnicalError {

  BEAN_NOT_FOUND("SRS-0001", "Cannot find bean with provided name.");

  private final String code;
  private final String message;

  TechnicalError(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
