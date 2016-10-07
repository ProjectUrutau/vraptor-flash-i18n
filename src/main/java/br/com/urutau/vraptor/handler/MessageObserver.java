package br.com.urutau.vraptor.handler;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Result;
import br.com.urutau.vraptor.handler.qualifier.Category;
import br.com.urutau.vraptor.handler.qualifier.Message;
import br.com.urutau.vraptor.i18n.I18nMessageCreator;

/**
 * Chain sequence would be: use(category).toShow(message)
 * .(redirectLogic); // optional
 */
@RequestScoped
public class MessageObserver {

	private static final Logger logger = LoggerFactory.getLogger(MessageObserver.class);

	private final I18nMessageCreator i18nCreator;
	private final Result result;
	private String category;

	public MessageObserver() {
		this(null, null);
	}

	@Inject
	public MessageObserver(I18nMessageCreator i18nCreator, Result result) {
		this.i18nCreator = i18nCreator;
		this.result = result;
	}

	public void setCategory(@Observes @Category String category) {
		logger.debug("category is " + category);
		this.category = category;
	}

	public void setMessage(@Observes @Message String message) {
		String translatedMessage = i18nCreator.translate(message).to(category).getMessage();

		logger.debug("Message translated is " + translatedMessage);

		result.include(category, translatedMessage);
	}
}
