package com.java.racine.tictactoe.core;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.MoreObjects;

/**
 * @author Mike
 *
 */
public class Coordinate {
	
	@Range(min = 0, max = 2)
	private int x;
	
	@Range(min = 0, max = 2)
	private int y;
	
	public Coordinate() {
		// Jackson deserialization
	}
	
	/**
	 * Default constructor
	 * @param x the desired X-coordinate
	 * @param y the desired Y-coordinate
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor
	 * @param c the coordinate to copy
	 */
	public Coordinate(Coordinate c) {
		this.x = c.getX();
		this.y = c.getY();
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeCoordinate#getX()
	 */
	@JsonProperty
	public int getX() {
		return x;
	}
	
	/**
	 * @param x the x to set
	 */
	@JsonProperty
	public void setX(int x) {
		this.x = x;
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeCoordinate#getY()
	 */
	@JsonProperty
	public int getY() {
		return y;
	}
	
	/**
	 * @param y the y to set
	 */
	@JsonProperty
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Tests if two coordinates are equal
	 * @param other the other coordinate to test this against
	 * @return whether the two coordinates are equal or not
	 */
	@Override
	public boolean equals(Object other) {
		
		boolean isEqual;
		
		if(other == null) {
			isEqual = false;
		}
		
		else if(other instanceof Coordinate) {
			
			Coordinate otherCoord = 
					new Coordinate((Coordinate) other);
			
			if(otherCoord.getX() == x && otherCoord.getY() == y) {
				isEqual = true;
			}
			
			else {
				isEqual = false;
			}
			
		}
		
		else {
			isEqual = false;
		}
		
		return isEqual;		
	}
	
	/**
	 * @return the hashCode of this coordinate
	 */
	@Override
	public int hashCode(){
		
		int hash = 3;
		final int prime = 31;
		
		hash = (prime * hash) + this.x;
		hash = (prime * hash) + this.y;
		
		return hash;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("x", x)
				.add("y", y)
				.toString();
	}
}
