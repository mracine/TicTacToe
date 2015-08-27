package com.java.racine.tictactoe.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author Mike Racine
 *
 */
public class ApplicationHealthCheck extends HealthCheck {
	
	public ApplicationHealthCheck() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}
}
