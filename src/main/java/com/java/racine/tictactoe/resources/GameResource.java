package com.java.racine.tictactoe.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.java.racine.tictactoe.api.CloseGameResponse;
import com.java.racine.tictactoe.api.CreateGameResponse;
import com.java.racine.tictactoe.api.JoinGameResponse;
import com.java.racine.tictactoe.api.MakeMoveResponse;
import com.java.racine.tictactoe.core.Game;
import com.java.racine.tictactoe.core.GameManager;
import com.java.racine.tictactoe.core.GameMove;
import com.java.racine.tictactoe.core.MoveResult;
import com.java.racine.tictactoe.core.Piece;
import com.java.racine.tictactoe.core.Player;
import com.java.racine.tictactoe.core.TicTacToeException;

/**
 * 
 * @author Mike Racine
 *
 */
@Path("/tictactoe")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

	/**
	 * Creates a new game, player, and designates that player as "X"
	 * @return a Json response
	 */
	@POST
	public CreateGameResponse createNewGame(@QueryParam("piece") Piece piece) {

		Game g = piece != null ? GameManager.getInstance().createNewGame(piece) : 
			GameManager.getInstance().createNewGame();

		// This will always find the game since we just created it
		Player p = GameManager.getInstance().addPlayer(g.getGameId());

		return new CreateGameResponse(g.getGameId(), p.getPlayerName(), p.getPlayerPiece());
	}

	/**
	 * Allows a new player to join a game of tic-tac-toe
	 * @param gameId the id of the game to join
	 * @return a Json response
	 */
	@POST
	@Path("/{gameId}")
	public JoinGameResponse joinExistingGame(@PathParam("gameId") long gameId) {

		JoinGameResponse response = new JoinGameResponse(-1, null, null);

		try {

			Game g = GameManager.getInstance().findGame(gameId);
			Player p = GameManager.getInstance().addPlayer(g.getGameId());
			response = new JoinGameResponse(g.getGameId(), p.getPlayerName(), p.getPlayerPiece());

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * @param gameId the game id
	 * @param move the move to make
	 * @return the result of the move
	 */
	@POST
	@Path("/{gameId}/makeMove")
	public MakeMoveResponse makeMove(@PathParam("gameId") long gameId, @Valid GameMove move) {

		MoveResult result = null;

		try {
			result = GameManager.getInstance().findGame(gameId).makeMove(move);
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}

		String playerName = GameManager.getInstance().findGame(gameId).getPlayers().get(0).getPlayerPiece() == move.getPiece() ? 
				GameManager.getInstance().findGame(gameId).getPlayers().get(0).getPlayerName() : 
					GameManager.getInstance().findGame(gameId).getPlayers().get(1).getPlayerName();

		return new MakeMoveResponse(gameId, playerName, move.getPiece(), result);
	}

	/**
	 * @param gameId the id of the game to close
	 */
	@POST
	@Path("/{gameId}/close")
	public CloseGameResponse closeGame(@PathParam("gameId") long gameId) {
		GameManager.getInstance().closeGame(gameId);
		return new CloseGameResponse(gameId, null, null);
	}

	/**
	 * @param gameId the id of the game
	 * @return a list of all moves made in this game
	 */
	@GET
	@Path("/{gameId}/getMoves")
	public List<GameMove> getMoves(@QueryParam("gameId") long gameId) {

		List<GameMove> moves = null;

		try {
			moves = GameManager.getInstance().findGame(gameId).getMoves();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return moves;
	}

	/**
	 * @return a list of tic-tac-toe games by id
	 */
	@GET
	@Path("/getGameIds")
	public List<Long> getGameIds() {
		return GameManager.getInstance().getGameIds();
	}
}
