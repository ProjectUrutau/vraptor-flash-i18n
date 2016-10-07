package br.com.urutau.vraptor.handler.error;

import br.com.caelum.vraptor.validator.Validator;
import br.com.urutau.vraptor.Category;

public interface ErrorMessageHandler {

	/**
	 * Sets the category that will be show
	 * 
	 * @param category {@link Category} Object with all contexts of system
	 */
	Judge use(String category);

	/**
	 * returns {@link Validator#hasErrors()}
	 */
	boolean hasErrors();

	/**
	 * @return {@link Validator#getErrors().size()} 
	 */
	int errorsCount();
}