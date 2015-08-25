package com.java.racine.tictactoe.api;

import java.util.UUID;

import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public class CreateGameResponse extends BaseResponse {

	public CreateGameResponse(UUID gameId, UUID playerId, Piece playerPiece) {
		super(gameId, playerId, playerPiece);
	}
}
