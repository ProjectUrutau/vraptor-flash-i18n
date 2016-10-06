package com.urutau.vraptor.handler;

import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

public interface Redirector {
	/**
	 * Uses {@link Validator#onErrorRedirectTo(Class)} to redirects to another action
	 * 
	 * @param controller contains action that will be called 
	 * @return {@link br.com.caelum.vraptor.Controller} to calls some action
	 */
	<Controller> Controller redirectingTo(Class<Controller> controller);

	/**
	 * Stay on the current page
	 * 
	 * @see {@link Results#referer()}
	 */
	void stayInCurrent();
}
