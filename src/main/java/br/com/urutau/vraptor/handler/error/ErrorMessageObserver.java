package br.com.urutau.vraptor.handler.error;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.urutau.vraptor.handler.qualifier.Category;
import br.com.urutau.vraptor.handler.qualifier.Condition;
import br.com.urutau.vraptor.handler.qualifier.Message;
import br.com.urutau.vraptor.i18n.I18nMessageCreator;

/**
 * Chain sequence would be: use(category).when(condition).toShow(message)
 * .(redirectingTo(XptoController).hello()); // optional
 */
@RequestScoped
public class ErrorMessageObserver {

	private final I18nMessageCreator i18nCreator;
	private final Validator validator;

	public ErrorMessageObserver() {
		this(null, null);
	}

	@Inject
	public ErrorMessageObserver(I18nMessageCreator i18nCreator, Validator validator) {
		this.i18nCreator = i18nCreator;
		this.validator = validator;
	}

	private String category;
	private boolean condition;

//	public void setCategory(@Observes @Category String category) {
//		this.category = category;
//	}
//
//	public void setCondition(@Observes @Condition Boolean condition) {
//		this.condition = condition;
//	}
//
//	public void setMessage(@Observes @Message String message) {
//		I18nMessage translatedMessage = i18nCreator.translate(message).to(category);
//		validator.addIf(condition, translatedMessage);
//	}
}
