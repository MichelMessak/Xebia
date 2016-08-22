package com.xebia.mowitnow.application.model;

/**
 * Class that represent coordinates. It is composed by two coordinates in 2D(X,Y).
 * 
 * @author Michel
 *
 */

public class Coordinates {

	private int x;
	private int y;
	
	public Coordinates(){
		super();
	}
	
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return X coordinates
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return Y coordinates
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return coordinates
	 */
	public String getCoordinates() {
		return ""+x+" "+y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		if (!(obj instanceof Coordinates)) {
			return false;
		}
		Coordinates other = (Coordinates) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Coordinates [x=" + x + ", y=" + y + "]";
	}
	
}
