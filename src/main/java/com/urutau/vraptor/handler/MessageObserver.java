package com.urutau.vraptor.handler;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.urutau.vraptor.handler.qualifier.Category;
import com.urutau.vraptor.handler.qualifier.Message;
import com.urutau.vraptor.i18n.I18nMessageCreator;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;

/**
 * Chain sequence would be: use(category).when(condition).toShow(message)
 * .(redirectingTo(XptoController).hello()); // optional
 */
@RequestScoped
public class MessageObserver {

	private final I18nMessageCreator i18nCreator;
	private final Result result;

	public MessageObserver() {
		this(null, null);
	}

	@Inject
	public MessageObserver(I18nMessageCreator i18nCreator, Result result) {
		this.i18nCreator = i18nCreator;
		this.result = result;
	}

	private String category;

	public void setCategory(@Observes @Category String category) {
		this.category = category;
	}

	public void setMessage(@Observes @Message String message) {
		I18nMessage translatedMessage = i18nCreator.translate(message).to(category);
		result.include(category, translatedMessage);
	}
}
