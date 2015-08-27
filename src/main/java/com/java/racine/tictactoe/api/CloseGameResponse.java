package com.java.racine.tictactoe.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.Piece;

public class CloseGameResponse extends BaseResponse {
	
	private List<Long> gameIds;

	public CloseGameResponse(long gameId, String playerName, Piece playerPiece) {
		super(gameId, playerName, playerPiece);
		gameIds = GameManager.getInstance().getGameIds();
	}

	/**
	 * @return the gameIds
	 */
	@JsonProperty
	public List<Long> getGameIds() {
		return gameIds;
	}
}
