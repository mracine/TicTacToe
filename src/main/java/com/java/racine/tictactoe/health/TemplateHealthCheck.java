/**
 * 
 */
package com.java.racine.tictactoe.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author Mike Racine
 *
 */
public class TemplateHealthCheck extends HealthCheck {
	
	private final String template;
	
	public TemplateHealthCheck(String template) {
		this.template = template;
	}

	/* (non-Javadoc)
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected Result check() throws Exception {
		final String saying = String.format(template, "TEST");
		if(!saying.contains("TEST")) {
			return Result.unhealthy("template doesn't include a name");
		}
		
		return Result.healthy();
	}
}
