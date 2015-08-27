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
	private Piece piece;
	
	@NotNull
	private Coordinate coord;
	
	public GameMove() {
		// Jackson deserialization
	}
	
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
	 * @param piece the piece to set
	 */
	@JsonProperty
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * @return the coord
	 */
	@JsonProperty
	public Coordinate getCoordinate() {
		return coord;
	}
	
	/**
	 * @param coord the coord to set
	 */
	@JsonProperty
	public void setCoordinate(Coordinate coord) {
		this.coord = coord;
	}
}
