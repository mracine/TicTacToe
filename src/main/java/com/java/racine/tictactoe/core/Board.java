package com.java.racine.tictactoe.core;

/**
 * @author Mike Racine
 *
 */
public interface Board {

	/**
	 * 
	 * @param coord the coordinate to place the piece at
	 * @param p the piece to place
	 */
	public void placePiece(Coordinate coord, Piece p);
	
	/**
	 * 
	 * @param x the X-coordinate to place the piece at
	 * @param y the Y-coordinate to place the piece at
	 * @param p the piece to place
	 */
	public void placePiece(int x, int y, Piece p);
	
	/**
	 * 
	 * @param coord the coordinate to check
	 * @return whether or not the given space is occupied
	 */
	public boolean isSpaceOccupied(Coordinate coord);
	
	/**
	 * 
	 * @param x the X-coordinate of the space to check
	 * @param y the Y-coordinate of the space to check
	 * @return whether or not the given space is occupied
	 */
	public boolean isSpaceOccupied(int x, int y);
	
	/**
	 * 
	 * @param coord the coordinate of a piece
	 * @return the piece at the given coordinate
	 */
	public Piece getPieceAt(Coordinate coord);
	
	/**
	 * 
	 * @param x the X-coordinate of a space
	 * @param y the Y-coordinate of a space
	 * @return the piece at the given coordinate
	 */
	public Piece getPieceAt(int x, int y);
	
	/**
	 * 
	 * @return the number of pieces on the board
	 */
	public int getNumPieces();
}
