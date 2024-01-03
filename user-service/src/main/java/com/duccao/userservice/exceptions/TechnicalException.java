package com.duccao.userservice.exceptions;

public class TechnicalException extends RuntimeException {

  private final TechnicalError error;

  public TechnicalException(TechnicalError error) {
    this.error = error;
  }

  public TechnicalException(String message, TechnicalError error) {
    super(message);
    this.error = error;
  }

  public TechnicalException(String message, Throwable cause, TechnicalError error) {
    super(message, cause);
    this.error = error;
  }

  public TechnicalException(Throwable cause, TechnicalError error) {
    super(cause);
    this.error = error;
  }

  public TechnicalError getError() {
    return error;
  }
}
