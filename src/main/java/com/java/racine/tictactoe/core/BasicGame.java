package com.java.racine.tictactoe.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mike Racine
 *
 */
public class BasicGame implements Game {
	
	private final long gameId;
	
	/**
	 * Player board bounds are a square from (0, 0) and (2, 2)
	 */
	private final Board board = new HashMapBoard();
	private List<Player> players = new ArrayList<Player>();
	private List<GameMove> moves = new ArrayList<GameMove>();
	private Piece currentPlayerTurn;
	private MoveResult lastMoveResult;
	
	private final String player1 = "Player1";
	private final String player2 = "Player2";
	
	public BasicGame(long gameId, Piece firstPlayer) {
		this.gameId = gameId;
		this.currentPlayerTurn = firstPlayer;
		this.lastMoveResult = MoveResult.OK;
	}	

	/* (non-Javadoc)
	 * @see com.java.racine.tictactoe.core.TicTacToeGame#makeMove()
	 */
	public MoveResult makeMove(GameMove move) throws TicTacToeException {
		
		if(move == null) {
			throw new TicTacToeException("Game received null move");
		}
		
		// Automatically return if the game has already ended
		else if(this.lastMoveResult != MoveResult.OK) {
			return lastMoveResult;
		}
		
		// Check that the player making the move is in the game
		else if(!isPlayerPieceRegistered(move.getPiece())) {
			throw new TicTacToeException("Player " + move.getPiece() + " has not joined the game yet");
		}
		
		// Check that piece being placed is valid with the current player's turn
		else if(move.getPiece() != this.currentPlayerTurn) {
			throw new TicTacToeException("Cannot place " + move.getPiece() + 
					" since it is " + this.currentPlayerTurn + "'s turn");
		}
		
		// Check that piece is not out of bounds
		else if(move.getCoordinate().getX() < 0 || move.getCoordinate().getX() > 2 || 
				move.getCoordinate().getY() < 0 || move.getCoordinate().getY() > 2){
			throw new TicTacToeException("Pieces must be placed between (0,0) and (2,2)");
		}
		
		// Check that the space is not occupied
		else if(board.isSpaceOccupied(move.getCoordinate())) {
			throw new TicTacToeException("Cannot claim an occupied space");
		}
		
		// Place the piece
		else {
			board.placePiece(move.getCoordinate(), currentPlayerTurn);
		}
		
		MoveResult result = lastMoveResult = getMoveResult(move.getPiece(), move.getCoordinate());
		moves.add(move);
		
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
			
			for(int i = 0; i < 3; i++) {
				
				if(board.getPieceAt(coord.getX(), i) == this.currentPlayerTurn) col++;
				if(board.getPieceAt(i, coord.getY()) == this.currentPlayerTurn) row++;
				if(board.getPieceAt(i, i) == this.currentPlayerTurn) diag++;
				if(board.getPieceAt(i, 3 - (i + 1)) == this.currentPlayerTurn) rdiag++;
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
	
	/**
	 * @param piece the piece to check
	 * @return whether or not the piece is registered to a player or not
	 */
	private boolean isPlayerPieceRegistered(Piece piece) {
		
		boolean isRegistered = false;
		
		for(Player player : players) {
			isRegistered = isRegistered || player.getPlayerPiece() == piece; 
		}
		
		return isRegistered;
	}

	public long getGameId() {
		return gameId;
	}

	public Player addPlayer() throws TicTacToeException {
		
		Player newPlayer;
		
		if(players.size() == 0) {
			newPlayer = new Player(player1, this.currentPlayerTurn);
			players.add(newPlayer);
		}
		
		else if(players.size() == 1) {
			newPlayer = new Player(player2, players.get(0).getPlayerPiece() == Piece.X ? Piece.O : Piece.X);
			players.add(newPlayer);
		}
		
		else
			throw new TicTacToeException("Cannot add more players, already 2 players in this game");
		
		return newPlayer;
	}
	
	public List<GameMove> getMoves() {
		return moves;
	}

	public List<Player> getPlayers() {
		return players;
	}
}
