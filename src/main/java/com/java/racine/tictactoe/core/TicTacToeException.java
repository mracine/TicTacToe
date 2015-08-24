package com.java.racine.tictactoe.core;

/**
 * @author Mike Racine
 *
 */
@SuppressWarnings("serial")
public class TicTacToeException extends Exception {

	/**
	 * The default constructor describing the error
	 */
	public TicTacToeException(String message) {
		super(message);
	}
}
