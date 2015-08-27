package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.TicTacToeFactory;

public class GameManagerTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testCreateGame() {
		Game g = GameManager.getInstance().createNewGame();

		try {
			assertEquals(g, GameManager.getInstance().findGame(g.getGameId()));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateGameWithPlayer() {
		Game g = GameManager.getInstance().createNewGame(Piece.O);

		try {
			assertEquals(g, GameManager.getInstance().findGame(g.getGameId()));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGameNotRegisteredWithManager() throws NullPointerException {
		Game g = TicTacToeFactory.getInstance().makeGame(-1);
		exception.expect(NullPointerException.class);
		GameManager.getInstance().findGame(g.getGameId());
	}
}
