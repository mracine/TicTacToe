package com.java.racine.tictactoe.core;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Mike Racine
 *
 */
public class GameMove {
	
	@NotNull
	private final Piece piece;
	
	@NotNull
	private final Coordinate coord;
	
	public GameMove(Piece piece, Coordinate coord) {
		this.piece = piece;
		this.coord = coord;
	}

	/**
	 * @return the player
	 */
	@JsonProperty
	public Piece getPiece() {
		return piece;
	}

	/**
	 * @return the coord
	 */
	@JsonProperty
	public Coordinate getCoordinate() {
		return coord;
	}
}
