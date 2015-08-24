package com.java.racine.tictactoe.core;

/**
 * @author Mike
 *
 */
public class BasicCoordinate implements Coordinate {
	
	private int x;
	private int y;
	
	/**
	 * Default constructor
	 * @param x the desired X-coordinate
	 * @param y the desired Y-coordinate
	 */
	public BasicCoordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Copy constructor
	 * @param c the coordinate to copy
	 */
	public BasicCoordinate(Coordinate c) {
		this.x = c.getX();
		this.y = c.getY();
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeCoordinate#getX()
	 */
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeCoordinate#getY()
	 */
	public int getY() {
		return y;
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
			
			BasicCoordinate otherCoord = 
					new BasicCoordinate((Coordinate) other);
			
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
}
