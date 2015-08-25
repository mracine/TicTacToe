package com.java.racine.tictactoe.api;

import java.util.UUID;

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
	protected UUID gameId;
	
	@NotNull
	protected UUID playerId;
	
	@NotNull
	protected Piece playerPiece;
	
	public BaseResponse(UUID gameId, UUID playerId, Piece playerPiece) {
		this.gameId = gameId;
		this.playerId = playerId;
		this.playerPiece = playerPiece;
	}
	
	/**
	 * @return the gameId
	 */
	@JsonProperty
	public UUID getGameId() {
		return gameId;
	}

	/**
	 * @return the playerId
	 */
	@JsonProperty
	public UUID getPlayerId() {
		return playerId;
	}
	
	/**
	 * @return the playerPiece
	 */
	@JsonProperty
	public Piece getPlayerPiece() {
		return playerPiece;
	}
}
