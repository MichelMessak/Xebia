package com.xebia.mowitnow.application.exception;

/**
 * 
 * Exception for incorrect input file.
 * 
 * @author Michel
 * 
 */
public class IncorrectFileException extends Exception {

	private static final long serialVersionUID = -57375607283356254L;

	public IncorrectFileException() {
		super();
	}

	public IncorrectFileException(String message) {
		super(message);
	}

	public IncorrectFileException(Throwable cause) {
		super(cause);
	}

	public IncorrectFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
