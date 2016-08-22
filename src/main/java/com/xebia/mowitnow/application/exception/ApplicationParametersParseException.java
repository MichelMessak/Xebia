/**
 * 
 */
package com.xebia.mowitnow.application.exception;

/**
 * 
 * Exceptions for invalids application's parameters.
 * 
 * @author Michel
 *
 */
public class ApplicationParametersParseException extends Exception {


  private static final long serialVersionUID = -4295341812170236181L;

  public ApplicationParametersParseException() {
  }

  public ApplicationParametersParseException(String message) {
    super(message);
  }

  public ApplicationParametersParseException(Throwable cause) {
    super(cause);
  }

  public ApplicationParametersParseException(String message, Throwable cause) {
    super(message, cause);
  }
  
}
