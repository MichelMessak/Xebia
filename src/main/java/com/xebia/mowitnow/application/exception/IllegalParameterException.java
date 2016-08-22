package com.xebia.mowitnow.application.exception;

/**
 * Exception for illegals parameters. 
 * 
 * @author Michel
 * 
 */
public class IllegalParameterException extends Exception {

	private static final long serialVersionUID = 1405966199168468047L;

	public IllegalParameterException() {
		super();
	}

	public IllegalParameterException(String message) {
		super(message);
	}

	public IllegalParameterException(Throwable cause) {
		super(cause);
	}

	public IllegalParameterException(String message, Throwable cause) {
		super(message, cause);
	}

}
