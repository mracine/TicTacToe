package com.java.racine.tictactoe.core;

import java.util.List;

/**
 * @author Mike Racine
 *
 */
public interface Game {
	
	/**
	 * @return the UUID of this game
	 */
	public long getGameId();
	
	/**
	 * Adds a player to this game
	 */
	public Player addPlayer() throws TicTacToeException;
	
	/**
	 * @return the number of players in this game
	 */
	public List<Player> getPlayers();
	
	/**
	 * Makes a move in the game and returns its result
	 */
	public MoveResult makeMove(GameMove move) throws TicTacToeException;
	
	/**
	 * @return a list of all moves made in this game
	 */
	public List<GameMove> getMoves();
}
