package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.TicTacToeFactory;

public class GameManagerTest {

	@Test
	public void testCreateGame() {
		Game g = GameManager.getInstance().createNewGame();
		assertEquals(g, GameManager.getInstance().findGame(g.getGameId()));
	}
	
	@Test
	public void testCreateGameWithPlayer() {
		Game g = GameManager.getInstance().createNewGame(Piece.O);
		assertEquals(g, GameManager.getInstance().findGame(g.getGameId()));
	}
	
	@Test
	public void testGameNotRegisteredWithManager() {
		Game g = TicTacToeFactory.getInstance().makeGame();
		assertNull(GameManager.getInstance().findGame(g.getGameId()));
	}
}
