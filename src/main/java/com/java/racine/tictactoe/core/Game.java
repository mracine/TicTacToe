package com.java.racine.tictactoe.core;

/**
 * @author Mike Racine
 *
 */
public interface Game {
	
	/**
	 * Makes a move in the game and returns its result
	 */
	public MoveResult makeMove(Piece piece, Coordinate coord) throws TicTacToeException;
	
}
