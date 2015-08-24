/**
 * 
 */
package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.BasicCoordinate;
import com.java.racine.tictactoe.core.Coordinate;

/**
 * @author Mike Racine
 *
 */
public class BasicCoordinateTest {
	
	@Test
	public void testConstructor() {
		Coordinate coord = new BasicCoordinate(0, 0);
		assertEquals(0, coord.getX());
		assertEquals(0, coord.getY());
	}
	
	@Test
	public void testCopyConstructor() {
		Coordinate coord = new BasicCoordinate(1, 1);
		Coordinate copyCoord = new BasicCoordinate(coord);
		assertEquals(1, copyCoord.getX());
		assertEquals(1, copyCoord.getY());		
	}
	
	@Test
	public void testGetCoords() {
		Coordinate coord = new BasicCoordinate(2, 2);
		assertEquals(2, coord.getX());
		assertEquals(2, coord.getY());		
	}
	
	@Test
	public void testEqualsWhenEqual() {
		Coordinate coord = new BasicCoordinate(1, 1);
		Coordinate copyCoord = new BasicCoordinate(coord);
		assertTrue(coord.equals(copyCoord));
	}
	
	@Test
	public void testEqualsWhenNotEqual() {
		Coordinate coord = new BasicCoordinate(1, 1);
		Coordinate otherCoord = new BasicCoordinate(0, 2);
		Coordinate otherCoord_2 = new BasicCoordinate(1, 2);
		assertFalse(coord.equals(otherCoord));
		assertFalse(coord.equals(otherCoord_2));
	}
	
	@Test
	public void testEqualsNull() {
		Coordinate coord = new BasicCoordinate(1, 1);
		assertFalse(coord.equals(null));
	}
	
	@Test
	public void testEqualsOtherClass() {
		Coordinate coord = new BasicCoordinate(1, 1);
		assertFalse(coord.equals(0));
	}
	
	@Test
	public void testHashCode() {
		Coordinate coord = new BasicCoordinate(1, 2);
		assertEquals(2916, coord.hashCode());
	}
}
