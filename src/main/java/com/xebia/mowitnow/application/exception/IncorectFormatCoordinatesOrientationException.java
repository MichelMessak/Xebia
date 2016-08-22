package com.xebia.mowitnow.application.exception;

/**
 * 
 * Exception for parsing coordinates and orientation lines.
 * 
 * @author Michel
 *
 */
public class IncorectFormatCoordinatesOrientationException extends Exception {

	private static final long serialVersionUID = 3478150692201243210L;

	public IncorectFormatCoordinatesOrientationException() {
		super();
	}

	public IncorectFormatCoordinatesOrientationException(String message) {
		super(message);
	}

	public IncorectFormatCoordinatesOrientationException(Throwable cause) {
		super(cause);
	}

	public IncorectFormatCoordinatesOrientationException(String message, Throwable cause) {
		super(message, cause);
	}
}
