package io.github.projecturutau.vraptor.handler;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

public interface FlashError {
	/**
	 *  @param category Used in {@link Validator} as category of {@link I18nMessage}
	 */
	public void validate(String category);
	
	/**
	 * Put a message into {@link Validator#getErrors()}
	 * 
	 * @param message to be translated
	 * @return 
	 */
	public Validator add(String message);
	
	/**
	 * @return current injected {@link Validator}
	 */
	public Validator getValidator();
}
