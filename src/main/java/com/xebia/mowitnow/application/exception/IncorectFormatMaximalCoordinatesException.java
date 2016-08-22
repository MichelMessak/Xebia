package com.xebia.mowitnow.application.exception;

/**
 * Exception for maximals coordinates line. 
 * 
 * @author Michel
 *
 */
public class IncorectFormatMaximalCoordinatesException extends Exception {

	private static final long serialVersionUID = 6599871631161432028L;

	public IncorectFormatMaximalCoordinatesException() {
		super();
	}

	public IncorectFormatMaximalCoordinatesException(String message) {
		super(message);
	}

	public IncorectFormatMaximalCoordinatesException(Throwable cause) {
		super(cause);
	}

	public IncorectFormatMaximalCoordinatesException(String message, Throwable cause) {
		super(message, cause);
	}

}
