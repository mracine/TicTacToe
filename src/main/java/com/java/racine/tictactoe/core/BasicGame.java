package com.java.racine.tictactoe.core;

/**
 * @author Mike Racine
 *
 */
public class BasicGame implements Game {
	
	/**
	 * Player board bounds are a square from (-1, -1) and (1, 1)
	 */
	private Board board = new HashMapBoard();
	private Piece currentPlayerTurn;
	private MoveResult lastMoveResult;
	
	public BasicGame(Piece firstPlayer) {
		this.currentPlayerTurn = firstPlayer;
		this.lastMoveResult = MoveResult.OK;
	}	

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeGame#makeMove()
	 */
	public MoveResult makeMove(Piece piece, Coordinate coord) throws TicTacToeException {
		
		// Automatically return if the game has already ended
		if(this.lastMoveResult != MoveResult.OK) {
			return lastMoveResult;
		}
		
		// Check that piece being placed is valid with the current player's turn
		else if(piece != this.currentPlayerTurn) {
			throw new TicTacToeException("Cannot place " + piece + 
					" since it is " + this.currentPlayerTurn + "'s turn");
		}
		
		// Check that piece is not out of bounds
		else if(coord.getX() < -1 || coord.getX() > 1 || 
				coord.getY() < -1 || coord.getY() > 1){
			throw new TicTacToeException("Pieces must be placed between (-1,-1) and (1,1)");
		}
		
		// Check that the space is not occupied
		else if(board.isSpaceOccupied(coord)) {
			throw new TicTacToeException("Cannot claim an occupied space");
		}
		
		// Place the piece
		else {
			board.placePiece(coord, currentPlayerTurn);
		}
		
		MoveResult result = lastMoveResult = getMoveResult(piece, coord);
		
		switchTurns();
		
		return result;
	}
	
	/**
	 * 
	 * @return the result of whether or not a game is over
	 */
	private MoveResult getMoveResult(Piece piece, Coordinate coord) {
		
		MoveResult result;
		
		// Game cannot be won until first player has taken third move
		if(board.getNumPieces() < 5) {
			result = MoveResult.OK;
		}
		
		else {
			
			int row, col, diag, rdiag;
			row = col = diag = rdiag = 0;
			
			for(int i = -1; i <= 1; i++) {
				
				if(board.getPieceAt(coord.getX(), i) == this.currentPlayerTurn) col++;
				if(board.getPieceAt(i, coord.getY()) == this.currentPlayerTurn) row++;
				if(board.getPieceAt(i, i) == this.currentPlayerTurn) diag++;
				if(board.getPieceAt(i, i * -1) == this.currentPlayerTurn) rdiag++;
			}
			
			if(row == 3 || col == 3 || diag == 3 || rdiag == 3) {
				result = currentPlayerTurn == Piece.X ? MoveResult.X_WINS : MoveResult.O_WINS;
			}
			
			else if(board.getNumPieces() >= 9) {
				result = MoveResult.DRAW;
			}
			
			else {
				result = MoveResult.OK;
			}
		}
		
		return result;
	}
	
	/**
	 * Switches player turns
	 */
	private void switchTurns() {
		this.currentPlayerTurn = this.currentPlayerTurn == Piece.X ? Piece.O : Piece.X;
	}
}
