package io.github.projecturutau.vraptor.handler.impl;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import io.github.projecturutau.vraptor.handler.FlashError;
import io.github.projecturutau.vraptor.i18n.I18nMessageCreator;

public class DefaultFlashError implements FlashError {

	private final Validator validator;
	private final I18nMessageCreator i18nCreator;

	private String category;

	public DefaultFlashError() {
		this(null, null);
	}

	@Inject
	public DefaultFlashError(Validator validator, I18nMessageCreator i18nCreator) {
		this.validator = validator;
		this.i18nCreator = i18nCreator;
	}

	@Override
	public void validate(String category) {
		this.category = category;
	}

	@Override
	public Validator add(String message) {
		if(category.equals(null)) {
			throw new NullPointerException("One category needs to "
					+ "be informed before you pass any error");
		}
		I18nMessage i18nMessage = i18nCreator.translate(message).to(category);
		validator.add(i18nMessage);
		return validator;
	}

	@Override
	public Validator getValidator() {
		return validator;
	}

}
