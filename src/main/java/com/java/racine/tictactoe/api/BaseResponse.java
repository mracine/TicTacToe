package com.java.racine.tictactoe.api;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public abstract class BaseResponse {
	
	@NotNull
	protected long gameId;
	
	@NotNull
	protected String playerName;
	
	@NotNull
	protected Piece playerPiece;
	
	public BaseResponse(long gameId, String playerName, Piece playerPiece) {
		this.gameId = gameId;
		this.playerName = playerName;
		this.playerPiece = playerPiece;
	}
	
	/**
	 * @return the gameId
	 */
	@JsonProperty
	public long getGameId() {
		return gameId;
	}

	/**
	 * @return the playerId
	 */
	@JsonProperty
	public String getPlayerName() {
		return playerName;
	}
	
	/**
	 * @return the playerPiece
	 */
	@JsonProperty
	public Piece getPlayerPiece() {
		return playerPiece;
	}
}
