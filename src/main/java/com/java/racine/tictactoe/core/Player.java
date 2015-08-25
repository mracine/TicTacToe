package com.java.racine.tictactoe.core;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import jersey.repackaged.com.google.common.base.MoreObjects;

/**
 * 
 * @author Mike Racine
 *
 */
public class Player {

	@NotNull
	private UUID playerId;
	
	@NotNull
	private Piece playerPiece;
	
	public Player(UUID playerId, Piece playerPiece) {
		this.playerId = playerId;
		this.playerPiece = playerPiece;
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
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("playerId:", playerId)
				.add("playerPiece", playerPiece)
				.toString();
	}
}
