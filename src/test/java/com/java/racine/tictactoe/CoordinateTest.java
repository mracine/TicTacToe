/**
 * 
 */
package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.racine.tictactoe.core.Coordinate;

/**
 * @author Mike Racine
 *
 */
public class CoordinateTest {
	
	@Test
	public void testConstructor() {
		Coordinate coord = new Coordinate(0, 0);
		assertEquals(0, coord.getX());
		assertEquals(0, coord.getY());
	}
	
	@Test
	public void testCopyConstructor() {
		Coordinate coord = new Coordinate(1, 1);
		Coordinate copyCoord = new Coordinate(coord);
		assertEquals(1, copyCoord.getX());
		assertEquals(1, copyCoord.getY());		
	}
	
	@Test
	public void testGetCoords() {
		Coordinate coord = new Coordinate(2, 2);
		assertEquals(2, coord.getX());
		assertEquals(2, coord.getY());		
	}
	
	@Test
	public void testEqualsWhenEqual() {
		Coordinate coord = new Coordinate(1, 1);
		Coordinate copyCoord = new Coordinate(coord);
		assertTrue(coord.equals(copyCoord));
	}
	
	@Test
	public void testEqualsWhenNotEqual() {
		Coordinate coord = new Coordinate(1, 1);
		Coordinate otherCoord = new Coordinate(0, 2);
		Coordinate otherCoord_2 = new Coordinate(1, 2);
		assertFalse(coord.equals(otherCoord));
		assertFalse(coord.equals(otherCoord_2));
	}
	
	@Test
	public void testEqualsNull() {
		Coordinate coord = new Coordinate(1, 1);
		assertFalse(coord.equals(null));
	}
	
	@Test
	public void testEqualsOtherClass() {
		Coordinate coord = new Coordinate(1, 1);
		assertFalse(coord.equals(0));
	}
	
	@Test
	public void testHashCode() {
		Coordinate coord = new Coordinate(1, 2);
		assertEquals(2916, coord.hashCode());
	}
	
	@Test
	public void testToString() {
		Coordinate coord = new Coordinate(2, 3);
		assertEquals("Coordinate{x=2, y=3}", coord.toString());
	}
}
