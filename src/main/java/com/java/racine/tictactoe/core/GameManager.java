package com.java.racine.tictactoe.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Manager for all games of Tic-Tac-Toe while application is running
 * @author Mike Racine
 *
 */
public class GameManager {
	
	private static final GameManager manager = new GameManager();
	
	private Map<UUID, Game> games = new HashMap<UUID, Game>();
	
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
		Game newGame = TicTacToeFactory.getInstance().makeGame();
		games.put(newGame.getGameId(), newGame);
		return newGame;
	}

	/**
	 * Creates a new game of Tic-Tac-Toe
	 * @param firstPlayer the player to move first
	 * @return the new Tic-Tac-Toe game
	 */
	public Game createNewGame(Piece firstPlayer) {
		Game newGame = TicTacToeFactory.getInstance().makeGame(firstPlayer);
		games.put(newGame.getGameId(), newGame);
		return newGame;
	}
	
	/**
	 * 
	 * @param gameId the UUID of the game requested
	 * @return the game if it exists, null otherwise
	 */
	public Game findGame(UUID gameId) {
		return games.containsKey(gameId) ? games.get(gameId) : null;
	}
	
	/**
	 * 
	 * @param gameId the UUID of the game requested
	 * @param p the UUID of the player to register
	 */
	public Player addPlayer(UUID gameId) {
		
		Player newPlayer;
		
		if(games.containsKey(gameId)) 
			newPlayer = games.get(gameId).addPlayer(UUID.randomUUID());
		else
			newPlayer = null;
		
		return newPlayer;
	}
	
	/**
	 * 
	 * @return a list of gameIds registered with the manager
	 */
	public List<UUID> getGameIds() {
		return new ArrayList<UUID>(games.keySet());
	}
	
	/**
	 * Removes all games
	 */
	public void clearAllGames() {
		games.clear();
	}
}
