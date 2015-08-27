package com.java.racine.tictactoe.api;

import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public class CreateGameResponse extends BaseResponse {

	public CreateGameResponse(long gameId, String playerName, Piece playerPiece) {
		super(gameId, playerName, playerPiece);
	}
}
