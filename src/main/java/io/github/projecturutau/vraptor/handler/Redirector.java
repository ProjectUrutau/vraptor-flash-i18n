package io.github.projecturutau.vraptor.handler;

import br.com.caelum.vraptor.validator.Validator;

public interface Redirector {
	/**
	 * Uses {@link Validator#onErrorRedirectTo(Class)} to redirects to another action
	 * 
	 * @param controller contains action that will be called 
	 * @return Controller to calls some action
	 */
	public <Controller> Controller redirectTo(Class<Controller> controller);
	
	public void sendJSON();

	/**
	 * Stay on the current page, this is the default behavior to POST and PUT methods 
	 * 
	 * {@link br.com.caelum.vraptor.view.Results#referer()}
	 */
	public void stay();
}
