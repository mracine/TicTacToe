package com.java.racine.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import com.codahale.metrics.health.HealthCheck.Result;
import com.java.racine.tictactoe.health.ApplicationHealthCheck;

/**
 * 
 * @author Mike Racine
 *
 */
public class ApplicationHealthCheckTest {

	@Test
	public void testHealthCheck() {
		ApplicationHealthCheck healthCheck = new ApplicationHealthCheck();
		assertEquals(Result.healthy(), healthCheck.execute());
	}
}
