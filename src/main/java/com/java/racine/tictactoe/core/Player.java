package com.java.racine.tictactoe.core;

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
	private String playerName;
	
	@NotNull
	private Piece playerPiece;
	
	public Player(String playerName, Piece playerPiece) {
		this.playerName = playerName;
		this.playerPiece = playerPiece;
	}

	/**
	 * @return the playerName
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
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("playerName", playerName)
				.add("playerPiece", playerPiece)
				.toString();
	}
}
