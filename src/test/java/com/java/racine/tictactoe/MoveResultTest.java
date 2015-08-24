/**
 * 
 */
package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.MoveResult;

/**
 * @author Mike Racine
 *
 */
public class MoveResultTest {
	
	@Test
	public void testMoveResult(){
		
		MoveResult okMove = MoveResult.OK;
		assertEquals(okMove, MoveResult.OK);
		
		MoveResult oWinsMove = MoveResult.O_WINS;
		assertEquals(oWinsMove, MoveResult.O_WINS);
		
		MoveResult xWinsMove = MoveResult.X_WINS;
		assertEquals(xWinsMove, MoveResult.X_WINS);
		
		MoveResult drawMove = MoveResult.DRAW;
		assertEquals(drawMove, MoveResult.DRAW);
	}
}
