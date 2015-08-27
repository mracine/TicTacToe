package com.java.racine.tictactoe.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manager for all games of Tic-Tac-Toe while application is running
 * @author Mike Racine
 *
 */
public class GameManager {

	private long gameCount = 0;

	private static final GameManager manager = new GameManager();

	private Map<Long, Game> games = new HashMap<Long, Game>();

	private GameManager() {
		//
	}

	public static GameManager getInstance() {
		return manager;
	}

	/**
	 * Creates a new game of Tic-Tac-Toe
	 * @return the new Tic-Tac-Toe game
	 */
	public Game createNewGame() {
		Game newGame = TicTacToeFactory.getInstance().makeGame(gameCount);
		games.put(newGame.getGameId(), newGame);
		gameCount++;
		return newGame;
	}

	/**
	 * Creates a new game of Tic-Tac-Toe
	 * @param firstPlayer the player to move first
	 * @return the new Tic-Tac-Toe game
	 */
	public Game createNewGame(Piece firstPlayer) {
		Game newGame = TicTacToeFactory.getInstance().makeGame(gameCount, firstPlayer);
		games.put(newGame.getGameId(), newGame);
		gameCount++;
		return newGame;
	}

	/**
	 * 
	 * @param gameId the UUID of the game requested
	 * @return the game if it exists, null otherwise
	 */
	public Game findGame(long gameId) throws NullPointerException {
		
		Game g = null;
		
		if(games.containsKey(gameId)) {
			g = games.get(gameId);
		}
		
		else {
			throw new NullPointerException("Game not found");
		}
		
		return g;
	}

	/**
	 * 
	 * @param gameId the UUID of the game requested
	 * @param p the UUID of the player to register
	 */
	public Player addPlayer(long gameId) {

		Player newPlayer = null;

		try {
			return games.get(gameId).addPlayer();
		}

		catch (TicTacToeException e) {
			e.printStackTrace();
		}

		return newPlayer;
	}

	/**
	 * 
	 * @return a list of gameIds registered with the manager
	 */
	public List<Long> getGameIds() {
		return new ArrayList<Long>(games.keySet());
	}

	/**
	 * @param gameId the id of the game to close
	 */
	public void closeGame(long gameId) {

		if(games.containsKey(gameId))
			games.remove(gameId);
	}

	/**
	 * Removes all games
	 */
	public void closeAllGames() {
		games.clear();
	}
}
