/**
 * 
 */
package com.java.racine.tictactoe;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.java.racine.tictactoe.resources.TicTacToeResource;
import com.java.racine.tictactoe.health.TemplateHealthCheck;

/**
 * @author Mike Racine
 *
 */
public class TicTacToeApplication extends Application<TicTacToeConfiguration> {
	
	public static void main(String[] args) throws Exception {
		new TicTacToeApplication().run(args);
	}
	
	@Override
	public String getName() {
		return "Tic-Tac-Toe";
	}
	
	@Override
	public void initialize(Bootstrap<TicTacToeConfiguration> bootstrap) {
		//
	}

	/* (non-Javadoc)
	 * @see io.dropwizard.Application#run(io.dropwizard.Configuration, io.dropwizard.setup.Environment)
	 */
	@Override
	public void run(TicTacToeConfiguration configuration, Environment environment) throws Exception {
		
		final TicTacToeResource resource = new TicTacToeResource(
				configuration.getTemplate(),
				configuration.getDefaultName()
		);
		
		final TemplateHealthCheck healthCheck = 
				new TemplateHealthCheck(configuration.getTemplate());
		
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		
		// Start new game
		
	}
}
