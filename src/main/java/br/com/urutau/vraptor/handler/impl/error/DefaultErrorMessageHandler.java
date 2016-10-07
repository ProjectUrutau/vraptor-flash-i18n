package br.com.urutau.vraptor.handler.impl.error;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.validator.Validator;
import br.com.urutau.vraptor.handler.error.ErrorMessageHandler;
import br.com.urutau.vraptor.handler.error.Judge;
import br.com.urutau.vraptor.handler.qualifier.Category;

@RequestScoped
public class DefaultErrorMessageHandler implements ErrorMessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(DefaultErrorMessageHandler.class);

	private final Validator validator;
	private final Judge judge;

	@Category
	private final Event<String> eventCategory;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultErrorMessageHandler() {
		this(null, null, null);
	}

	@Inject
	public DefaultErrorMessageHandler(Validator validator, Judge judge, 
			Event<String> event) {
		this.validator = validator;
		this.judge = judge;
		this.eventCategory = event;
	}

	public Judge use(String category) {
		logger.info("Select category " + category);
		eventCategory.fire(category);
		return judge;
	}

	public boolean hasErrors() {
		return validator.hasErrors();
	}

	public int errorsCount() {
		return validator.getErrors().size();
	}
}
