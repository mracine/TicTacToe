/**
 * 
 */
package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.racine.tictactoe.core.Coordinate;
import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.GameMove;
import com.java.racine.tictactoe.core.MoveResult;
import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.TicTacToeException;

/**
 * @author Mike Racine
 *
 */
public class BasicGameTest {

	private final GameManager manager = GameManager.getInstance();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testXWins() {

		try {
			Game g = manager.createNewGame(Piece.X);
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(2,0))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(2,2))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testOWins() {

		try {
			Game g = manager.createNewGame(Piece.O);
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(0,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(2,0))));
			assertEquals(MoveResult.O_WINS, g.makeMove(new GameMove(Piece.O, new Coordinate(2,2))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMoveAfterGameEnd() {

		try {
			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(2,0))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(2,2))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(1,2))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testCorrectPlayerTurn() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Cannot place O since it is X's turn");
		g.makeMove(new GameMove(Piece.O, new Coordinate(0,0)));
	}

	@Test
	public void testOutOfBounds_1() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (0,0) and (2,2)");
		g.makeMove(new GameMove(Piece.X, new Coordinate(-1,0)));
	}

	@Test
	public void testOutOfBounds_2() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (0,0) and (2,2)");
		g.makeMove(new GameMove(Piece.X, new Coordinate(3,0)));
	}

	@Test
	public void testOutOfBounds_3() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (0,0) and (2,2)");
		g.makeMove(new GameMove(Piece.X, new Coordinate(0,-1)));
	}

	@Test
	public void testOutOfBounds_4() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (0,0) and (2,2)");
		g.makeMove(new GameMove(Piece.X, new Coordinate(0,3)));
	}

	@Test
	public void testOccupiedSpace() throws TicTacToeException {

		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Cannot claim an occupied space");
		g.makeMove(new GameMove(Piece.X, new Coordinate(0,0)));
		g.makeMove(new GameMove(Piece.O, new Coordinate(0,0)));
	}

	@Test
	public void testGameDraw() {

		try {
			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(2,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(0,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(2,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(2,0))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(0,2))));
			assertEquals(MoveResult.DRAW, g.makeMove(new GameMove(Piece.X, new Coordinate(1,0))));

		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRDiagWin() {

		try {
			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(2,2))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(2,0))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testRowWin() {

		try {
			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(0,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(1,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,2))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(2,1))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testColWin() {

		try {
			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(1,2))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.X, new Coordinate(0,1))));
			assertEquals(MoveResult.OK, g.makeMove(new GameMove(Piece.O, new Coordinate(2,2))));
			assertEquals(MoveResult.X_WINS, g.makeMove(new GameMove(Piece.X, new Coordinate(0,0))));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testGameId() {
		Game g = manager.createNewGame();
		long gameId = g.getGameId();
		assertEquals(gameId, g.getGameId());
	}

	@Test
	public void testNullMove() throws TicTacToeException {
		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		GameManager.getInstance().addPlayer(g.getGameId());
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Game received null move");
		g.makeMove(null);
	}

	@Test
	public void testGetMoves() {

		try {

			Game g = manager.createNewGame();
			GameManager.getInstance().addPlayer(g.getGameId());
			GameManager.getInstance().addPlayer(g.getGameId());
			List<GameMove> moves = new ArrayList<GameMove>();
			GameMove move_1 = new GameMove(Piece.X, new Coordinate(0,0));
			moves.add(move_1);
			g.makeMove(move_1);
			assertEquals(moves, g.getMoves());
			GameMove move_2 = new GameMove(Piece.O, new Coordinate(0, 1));
			moves.add(move_2);
			g.makeMove(move_2);
			assertEquals(moves, g.getMoves());

		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddPlayer() throws TicTacToeException {

		Game g = manager.createNewGame();
		assertEquals(0, g.getPlayers().size());
		g.addPlayer();
		assertEquals(1, g.getPlayers().size());
		g.addPlayer();
		assertEquals(2, g.getPlayers().size());
		exception.expect(TicTacToeException.class);
		g.addPlayer();
	}

	@Test
	public void testAddPlayerOFirst() {

		try {
			Game g = manager.createNewGame(Piece.O);
			assertEquals(0, g.getPlayers().size());
			g.addPlayer();
			assertEquals(1, g.getPlayers().size());
			g.addPlayer();
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPlayerNotInGame() throws TicTacToeException {
		Game g = manager.createNewGame();
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Player X has not joined the game yet");
		g.makeMove(new GameMove(Piece.X, new Coordinate(0,0)));
	}

	@Test
	public void testPlayerNotInGame_2() throws TicTacToeException {
		Game g = manager.createNewGame();
		GameManager.getInstance().addPlayer(g.getGameId());
		g.makeMove(new GameMove(Piece.X, new Coordinate(0,0)));
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Player O has not joined the game yet");
		g.makeMove(new GameMove(Piece.O, new Coordinate(0,1)));
	}

	@Test
	public void testGameManagerGameNotExist() {
		manager.createNewGame();
		exception.expect(NullPointerException.class);
		GameManager.getInstance().addPlayer(100);
	}

	@Test
	public void testGameManagerGetIds() {

		manager.closeAllGames();
		assertTrue(manager.getGameIds().isEmpty());
		Game g_1 = manager.createNewGame();
		assertTrue(manager.getGameIds().contains(g_1.getGameId()));
		Game g_2 = manager.createNewGame();
		assertTrue(manager.getGameIds().contains(g_2.getGameId()));
		Game g_3 = manager.createNewGame();
		assertTrue(manager.getGameIds().contains(g_3.getGameId()));
	}
}
