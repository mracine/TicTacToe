package com.java.racine.tictactoe.core;

import java.util.UUID;

/**
 * @author Mike Racine
 *
 */
public class TicTacToeFactory {
	
	private static final TicTacToeFactory factory = new TicTacToeFactory();
	
	/**
	 * Default constructor for singleton
	 */
	private TicTacToeFactory() {
		// Empty
	}
	
	/**
	 * Retrieves singleton
	 */
	public static TicTacToeFactory getInstance() {
		return factory;
	}
	
	/**
	 * Returns a game of TicTacToe (better design for different game types if necessary)
	 * If no firstPlayer is specified, X will move first by default
	 * @return a tic-tac-toe game
	 */
	public Game makeGame() {
		return new BasicGame(UUID.randomUUID(), Piece.X);
	}
	
	/**
	 * 
	 * @param firstPlayer the piece to take a space on the board first
	 * @return a tic-tac-toe game
	 */
	public Game makeGame(Piece firstPlayer) {
		return new BasicGame(UUID.randomUUID(), firstPlayer);
	}
}
