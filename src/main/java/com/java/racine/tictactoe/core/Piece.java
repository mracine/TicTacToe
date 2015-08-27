package com.java.racine.tictactoe.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Mike Racine
 * 
 * The pieces that a player can place in Tic-Tac-Toe
 *
 */
public enum Piece {
	X, O;
	
	private static Map<String, Piece> namesMap = new HashMap<String, Piece>();
	
	static {
		namesMap.put("X", X);
		namesMap.put("O", O);
	}
	
	@JsonCreator
	public static Piece forValue(String value) {
		return namesMap.get(value);
	}
	
	@JsonValue
	public String toValue() {
		for(Entry<String, Piece> entry : namesMap.entrySet()) {
			if(entry.getValue() == this)
				return entry.getKey();
		}
		
		return null;
	}
}
