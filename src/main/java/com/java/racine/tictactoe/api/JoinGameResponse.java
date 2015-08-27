package com.java.racine.tictactoe.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.GameMove;
import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public class JoinGameResponse extends BaseResponse {

	private List<GameMove> movesMade;
	
	public JoinGameResponse(long gameId, String playerName, Piece playerPiece) {
		super(gameId, playerName, playerPiece);
		
		try {
			movesMade = GameManager.getInstance().findGame(gameId).getMoves();
		} catch (NullPointerException e) {
			movesMade = null;
			e.printStackTrace();
		}
	}
	
	@JsonProperty
	public List<GameMove> getMovesMade() {
		return movesMade;
	}
}
