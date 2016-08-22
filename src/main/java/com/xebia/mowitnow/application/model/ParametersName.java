package com.xebia.mowitnow.application.model;

/**
 * Enum that represent application's parameters.
 * 
 * @author Michel
 *
 */
public enum ParametersName {

	/**
	 * Source
	 */
	F_SOURCE("source");

	private String name;

	private ParametersName(String name) {
		this.name = name;
	}

	/**
	 * @return enum's value
	 */
	public String getValue() {
		return name;
	}
}
