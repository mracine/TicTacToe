package com.java.racine.tictactoe.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mike Racine
 *
 */
public class HashMapBoard implements Board {
	
	private Map<Coordinate, Piece> board = new HashMap<Coordinate, Piece>();

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#placePiece(com.java.racine.tictactoe.core.Coordinate, com.java.racine.tictactoe.core.Piece)
	 */
	public void placePiece(Coordinate coord, Piece p) {
		board.put(coord, p);
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#placePiece(int, int, com.java.racine.tictactoe.core.Piece)
	 */
	public void placePiece(int x, int y, Piece p) {
		board.put(new Coordinate(x, y), p);
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#isSpaceOccupied(com.java.racine.tictactoe.core.Coordinate)
	 */
	public boolean isSpaceOccupied(Coordinate coord) {
		return board.containsKey(coord);
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#isSpaceOccupied(int, int)
	 */
	public boolean isSpaceOccupied(int x, int y) {
		return board.containsKey(new Coordinate(x, y));
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#getPieceAt(com.java.racine.tictactoe.core.Coordinate)
	 */
	public Piece getPieceAt(Coordinate coord) {
		return isSpaceOccupied(coord) ? board.get(coord) : null;
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#getPieceAt(int, int)
	 */
	public Piece getPieceAt(int x, int y) {
		return isSpaceOccupied(x, y) ? board.get(new Coordinate(x, y)) : null;
	}

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.Board#getNumPieces()
	 */
	public int getNumPieces() {
		return board.size();
	}
}
