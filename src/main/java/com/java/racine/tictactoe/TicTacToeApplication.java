/**
 * 
 */
package com.java.racine.tictactoe;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.java.racine.tictactoe.health.TemplateHealthCheck;
import com.java.racine.tictactoe.resources.GameResource;

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
		
		final GameResource resource = new GameResource();
		
		final TemplateHealthCheck healthCheck = 
				new TemplateHealthCheck(configuration.getTemplate());
		
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}
}
