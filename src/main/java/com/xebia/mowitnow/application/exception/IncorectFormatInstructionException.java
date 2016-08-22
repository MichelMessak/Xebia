package com.xebia.mowitnow.application.exception;

/**
 * Exception for incorrect format instructions line. 
 * 
 * @author Michel
 *
 */
public class IncorectFormatInstructionException extends Exception {

	private static final long serialVersionUID = -1061787670537136485L;

	public IncorectFormatInstructionException() {
		super();
	}

	public IncorectFormatInstructionException(String message) {
		super(message);
	}

	public IncorectFormatInstructionException(Throwable cause) {
		super(cause);
	}

	public IncorectFormatInstructionException(String message, Throwable cause) {
		super(message, cause);
	}

}
