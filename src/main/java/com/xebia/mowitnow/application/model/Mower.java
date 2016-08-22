package com.xebia.mowitnow.application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Mower. It is composed by an orientation enum, some
 * coordinates and a list of instructions.
 * 
 * @author Michel
 *
 */

public class Mower {

	private Orientation orientation;
	private Coordinates coordinates;
	private List<Instruction> instructions;

	public Mower() {
	}

	/**
	 * @return mower orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return mower coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * @return mower instructions
	 */
	public List<Instruction> getInstructions() {
		return instructions;
	}

	/**
	 * @param instruction
	 */
	public void addInstruction(Instruction instruction) {
		if (this.instructions == null) {
			this.instructions = new ArrayList<Instruction>();
		}
		this.instructions.add(instruction);
	}

	/**
	 * @param instructions
	 */
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	/**
	 * Get into a String, the current mower's coordinates and orientation
	 * 
	 * @return current coordinates and orientation
	 */
	public String getCurrentCoordinatesAndOrientation() {
		return "" + this.coordinates.getCoordinates() + " " + this.orientation;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mower)) {
			return false;
		}
		Mower other = (Mower) obj;
		if (coordinates == null) {
			if (other.coordinates != null) {
				return false;
			}
		} else if (!coordinates.equals(other.coordinates)) {
			return false;
		}
		if (instructions == null) {
			if (other.instructions != null) {
				return false;
			}
		} else if (!instructions.equals(other.instructions)) {
			return false;
		}
		if (orientation != other.orientation) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Mower [orientation=" + orientation + ", coordinates=" + coordinates + ", instructions=" + instructions
				+ "]";
	}

}
