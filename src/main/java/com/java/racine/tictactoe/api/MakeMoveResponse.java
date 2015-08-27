package com.java.racine.tictactoe.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.GameMove;
import com.java.racine.tictactoe.core.MoveResult;
import com.java.racine.tictactoe.core.Piece;

/**
 * 
 * @author Mike Racine
 *
 */
public class MakeMoveResponse extends BaseResponse {
	
	private final MoveResult result;
	private List<GameMove> movesMade;

	public MakeMoveResponse(long gameId, String playerName, Piece playerPiece, MoveResult result) {
		super(gameId, playerName, playerPiece);
		
		try {
			this.movesMade = GameManager.getInstance().findGame(gameId).getMoves();
		} catch (NullPointerException e) {
			this.movesMade = null;
			e.printStackTrace();
		}
		
		this.result = result;
	}
	
	/**
	 * @return the movesMade
	 */
	@JsonProperty
	public List<GameMove> getMovesMade() {
		return movesMade;
	}
	
	/**
	 * @return the result
	 */
	@JsonProperty
	public MoveResult getResult() {
		return result;
	}
}
