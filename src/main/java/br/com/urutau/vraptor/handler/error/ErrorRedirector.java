package br.com.urutau.vraptor.handler.error;

import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

public interface ErrorRedirector {
	/**
	 * Uses {@link Validator#onErrorRedirectTo(Class)} to redirects to another action
	 * 
	 * @param controller contains action that will be called 
	 * @return {@link br.com.caelum.vraptor.Controller} to calls some action
	 */
	<Controller> Controller redirectingTo(Class<Controller> controller);

	/**
	 * Uses {@link Validator#onErrorUse(Class)} to send a JSON format
	 * that contains all errors added.
	 */
	void sendJSON();
	
	/**
	 * Uses {@link Validator#onErrorUsePageOf(Object)} to redirects to certain page
	 * 
	 * @param controller contains page references
	 * @return {@link br.com.caelum.vraptor.Controller} to calls some page  
	 */
	<Controller> Controller onErrorUsePageOf(Class<Controller> controller);

	/**
	 * Stay on the current page
	 * 
	 * @see {@link Results#referer()}
	 */
	void stayInCurrent();
}
