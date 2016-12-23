package br.com.urutau.vraptor.handler;

import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

public interface Redirector {
	/**
	 * Uses {@link Validator#onErrorRedirectTo(Class)} to redirects to another action
	 * 
	 * @param controller contains action that will be called 
	 * @return {@link br.com.caelum.vraptor.Controller} to calls some action
	 */
	<Controller> Controller redirectTo(Class<Controller> controller);
	
	void sendJSON();

	/**
	 * Stay on the current page, this is the default behavior to POST and PUT methods 
	 * 
	 * @see {@link Results#referer()}
	 */
	void stay();
}
