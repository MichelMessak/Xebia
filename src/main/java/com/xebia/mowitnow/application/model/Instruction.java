package com.xebia.mowitnow.application.model;

/**
 * Enum that represent all instructions availables. 
 * 
 * @author Michel
 *
 */

public enum Instruction {

	/**
	 * Instruction Forward.
	 */
	A(0),
	
	/**
	 * Instruction Left.
	 */
	G(-1),
	
	/**
	 * Instruction Right.
	 */
	D(1);

	private Integer value;

	Instruction(Integer value) {
		this.value = value;
	}
	
	public int getValue() { 
		return value; 
	}

}
