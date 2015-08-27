package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.Player;

public class PlayerTest {

	@Test
	public void testPlayerId() {
		Player p = new Player("Bob", Piece.X);
		assertEquals("Bob", p.getPlayerName());
		assertEquals(Piece.X, p.getPlayerPiece());
	}
	
	@Test
	public void testPlayerToString() {
		Player p = new Player("Joe", Piece.O);
		assertEquals("Player{playerName=Joe, playerPiece=O}", p.toString());
	}
}
