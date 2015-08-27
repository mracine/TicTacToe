package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.racine.tictactoe.api.CloseGameResponse;
import com.java.racine.tictactoe.api.CreateGameResponse;
import com.java.racine.tictactoe.api.JoinGameResponse;
import com.java.racine.tictactoe.api.MakeMoveResponse;
import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.MoveResult;
import com.java.racine.tictactoe.core.Piece;

public class GameResponseTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testCreateGameResponse() {
		CreateGameResponse response = new CreateGameResponse(0, null, Piece.X);
		assertEquals(0, response.getGameId());
		assertNull(response.getPlayerName());
		assertEquals(Piece.X, response.getPlayerPiece());
	}

	@Test
	public void testJoinGameResponse() {
		Game g = GameManager.getInstance().createNewGame();
		JoinGameResponse response = new JoinGameResponse(g.getGameId(), null, Piece.O);
		assertEquals(g.getGameId(), response.getGameId());
		assertNull(response.getPlayerName());
		assertEquals(Piece.O, response.getPlayerPiece());
		assertEquals(0, response.getMovesMade().size());
	}

	@Test
	public void testCloseGameResponse() {
		Game g = GameManager.getInstance().createNewGame();
		CloseGameResponse response = new CloseGameResponse(g.getGameId(), null, null);
		assertEquals(g.getGameId(), response.getGameId());
		assertNull(response.getPlayerName());
		assertNull(response.getPlayerPiece());
	}
	
	@Test
	public void testMakeMoveResponse() {
		Game g = GameManager.getInstance().createNewGame();
		MakeMoveResponse response = new MakeMoveResponse(g.getGameId(), "Player 1", Piece.X, MoveResult.OK);
		assertEquals(g.getGameId(), response.getGameId());
		assertEquals("Player 1", response.getPlayerName());
		assertEquals(Piece.X, response.getPlayerPiece());
		assertEquals(MoveResult.OK, response.getResult());
		assertEquals(0, response.getMovesMade().size());
	}
}
