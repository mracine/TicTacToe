package com.java.racine.tictactoe.api;

import java.util.List;
import java.util.UUID;

import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.GameMove;
import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public class JoinGameResponse extends BaseResponse {

	List<GameMove> movesMade;
	
	public JoinGameResponse(UUID gameId, UUID playerId, Piece playerPiece) {
		super(gameId, playerId, playerPiece);
		movesMade = GameManager.getInstance().findGame(gameId).getMoves();
	}
}
