/**
 * 
 */
package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.java.racine.tictactoe.core.BasicCoordinate;
import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.MoveResult;
import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.TicTacToeException;
import com.java.racine.tictactoe.core.TicTacToeFactory;

/**
 * @author Mike Racine
 *
 */
public class BasicGameTest {

	private final TicTacToeFactory factory = TicTacToeFactory.getInstance();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testXWins() {

		try {
			Game g = factory.makeGame(Piece.X);
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(1,-1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(1,1)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testOWins() {

		try {
			Game g = factory.makeGame(Piece.O);
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(-1,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(1,-1)));
			assertEquals(MoveResult.O_WINS, g.makeMove(Piece.O, new BasicCoordinate(1,1)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMoveAfterGameEnd() {

		try {
			Game g = factory.makeGame(Piece.X);
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(1,-1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(1,1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(0,1)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testCorrectPlayerTurn() throws TicTacToeException {

		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Cannot place O since it is X's turn");
		g.makeMove(Piece.O, new BasicCoordinate(-1,-1));
	}

	@Test
	public void testOutOfBounds_1() throws TicTacToeException {
		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (-1,-1) and (1,1)");
		g.makeMove(Piece.X, new BasicCoordinate(-2,-1));
	}

	@Test
	public void testOutOfBounds_2() throws TicTacToeException {
		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (-1,-1) and (1,1)");
		g.makeMove(Piece.X, new BasicCoordinate(-1,-2));
	}

	@Test
	public void testOutOfBounds_3() throws TicTacToeException {
		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (-1,-1) and (1,1)");
		g.makeMove(Piece.X, new BasicCoordinate(2,-1));
	}

	@Test
	public void testOutOfBounds_4() throws TicTacToeException {
		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Pieces must be placed between (-1,-1) and (1,1)");
		g.makeMove(Piece.X, new BasicCoordinate(-1,2));
	}

	@Test
	public void testOccupiedSpace() throws TicTacToeException {
		Game g = factory.makeGame(Piece.X);
		exception.expect(TicTacToeException.class);
		exception.expectMessage("Cannot claim an occupied space");
		g.makeMove(Piece.X, new BasicCoordinate(0,0));
		g.makeMove(Piece.O, new BasicCoordinate(0,0));
	}

	@Test
	public void testGameDraw() {

		try {
			Game g = factory.makeGame(Piece.X);
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(1,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(-1,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(1,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(1,-1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(-1,1)));
			assertEquals(MoveResult.DRAW, g.makeMove(Piece.X, new BasicCoordinate(0,-1)));
			
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRDiagWin() {

		try {
			Game g = factory.makeGame();
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(1,1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(1,-1)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testRowWin() {

		try {
			Game g = factory.makeGame();
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(-1,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(0,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(1,0)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testColWin() {

		try {
			Game g = factory.makeGame();
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(0,1)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.X, new BasicCoordinate(-1,0)));
			assertEquals(MoveResult.OK, g.makeMove(Piece.O, new BasicCoordinate(1,1)));
			assertEquals(MoveResult.X_WINS, g.makeMove(Piece.X, new BasicCoordinate(-1,-1)));
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}		
	}
}
