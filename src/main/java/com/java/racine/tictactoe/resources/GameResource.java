package com.java.racine.tictactoe.resources;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.java.racine.tictactoe.api.CreateGameResponse;
import com.java.racine.tictactoe.api.JoinGameResponse;
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
	public CreateGameResponse createNewGame() {
		Game g = GameManager.getInstance().createNewGame();
		Player p = GameManager.getInstance().addPlayer(g.getGameId());
		return new CreateGameResponse(g.getGameId(), p.getPlayerId(), p.getPlayerPiece());
	}
	
	/**
	 * Creates a new game, player, and designates that player as whatever he/she chose
	 * @return a Json response
	 */
//	@POST
//	public CreateGameResponse createNewGame(@Valid Piece playerPiece) {
//		Game g = GameManager.getInstance().createNewGame(playerPiece);
//		Player p = GameManager.getInstance().addPlayer(g.getGameId());
//		return new CreateGameResponse(g.getGameId(), p.getPlayerId(), p.getPlayerPiece());
//	}
	
	/**
	 * Allows a new player to join a game of tic-tac-toe
	 * @param gameId the id of the game to join
	 * @return a Json response
	 */
	@POST
	@Path("/{gameId}")
	public JoinGameResponse joinExistingGame(@PathParam("gameId") UUID gameId) {
		Game g = GameManager.getInstance().findGame(gameId);
		Player p = GameManager.getInstance().addPlayer(g.getGameId());
		return new JoinGameResponse(g.getGameId(), p.getPlayerId(), p.getPlayerPiece());
	}
	
	/**
	 * @param gameId the game id
	 * @param move the move to make
	 * @return the result of the move
	 */
	@POST
	@Path("/{gameId}/makeMove")
	public MoveResult makeMove(@PathParam("gameId") UUID gameId, @Valid GameMove move) {
		
		MoveResult result = null;
		
		try {
			result = GameManager.getInstance().findGame(gameId).makeMove(move);
		} catch (TicTacToeException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @return a list of tic-tac-toe games by id
	 */
	@GET
	@Path("/getGameIds")
	public List<UUID> getGameIds() {
		return GameManager.getInstance().getGameIds();
	}
	
	/**
	 * @param gameId the id of the game
	 * @return a list of all moves made in this game
	 */
	@GET
	@Path("/{gameId}/getMoves")
	public List<GameMove> getMoves(@QueryParam("gameId") UUID gameId) {
		return GameManager.getInstance().findGame(gameId).getMoves();
	}
}
