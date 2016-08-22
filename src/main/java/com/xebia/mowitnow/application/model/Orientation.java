package com.xebia.mowitnow.application.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum that represent all mower's orientation avalaible.
 * 
 * @author Michel
 *
 */

public enum Orientation {

	/**
	 * Orientation North
	 */
	N(0),

	/**
	 * Orientation East
	 */
	E(1),

	/**
	 * Orientation South
	 */
	S(2),

	/**
	 * Orientation West
	 */
	W(3);

	private static Map<Integer, Orientation> map = new HashMap<Integer, Orientation>();

	private Integer value;

	static {
		for (Orientation orientation : Orientation.values()) {
			map.put(orientation.value, orientation);
		}
	}

	Orientation(Integer value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	/**
	 * @param orientationValue
	 * @return Orientation by it's value
	 */
	public static Orientation valueOf(Integer orientationValue) {
		return map.get(orientationValue);
	}

}
