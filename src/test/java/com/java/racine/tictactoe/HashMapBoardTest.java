package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.BasicCoordinate;
import com.java.racine.tictactoe.core.Board;
import com.java.racine.tictactoe.core.HashMapBoard;
import com.java.racine.tictactoe.core.Piece;

public class HashMapBoardTest {
	
	@Test
	public void testPiecePlacementUsingCoord() {
		Board b = new HashMapBoard();
		b.placePiece(new BasicCoordinate(0, 1), Piece.X);
		assertTrue(b.isSpaceOccupied(new BasicCoordinate(0, 1)));
		assertFalse(b.isSpaceOccupied(new BasicCoordinate(0, 0)));
	}
	
	@Test
	public void testPiecePlacementUsingInts() {
		Board b = new HashMapBoard();
		b.placePiece(0, 1, Piece.X);
		assertTrue(b.isSpaceOccupied(0, 1));
		assertFalse(b.isSpaceOccupied(0, 0));
	}
	
	@Test
	public void testGetPieceAtUsingCoord() {
		Board b = new HashMapBoard();
		b.placePiece(new BasicCoordinate(1, -1), Piece.X);
		assertTrue(b.isSpaceOccupied(new BasicCoordinate(1, -1)));
		assertEquals(Piece.X, b.getPieceAt(new BasicCoordinate(1, -1)));
	}

	@Test
	public void testGetPieceAtUsingInts() {
		Board b = new HashMapBoard();
		b.placePiece(-1, 1, Piece.O);
		assertTrue(b.isSpaceOccupied(-1, 1));
		assertEquals(Piece.O, b.getPieceAt(-1, 1));
	}
	
	@Test
	public void testGetPieceAtNull() {
		Board b = new HashMapBoard();
		assertEquals(null, b.getPieceAt(new BasicCoordinate(0, 0)));
		assertEquals(null, b.getPieceAt(0, 0));
	}
}
