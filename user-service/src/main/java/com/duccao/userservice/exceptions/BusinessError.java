package com.duccao.userservice.exceptions;

public enum BusinessError {

  ENTITY_NOT_FOUND("SRS-0001", "error.entity.not_found");

  private final String code;
  private final String message;

  BusinessError(String code, String message) {
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
