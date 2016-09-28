package com.urutau.vraptor.i18n;

import java.util.ResourceBundle;

import javax.enterprise.context.Dependent;

import com.urutau.vraptor.Category;

import br.com.caelum.vraptor.validator.I18nMessage;

@Dependent
public class I18nMessageCreator {
	private static final String FILE_MESSAGE = "messages";

	private I18nMessage i18nMessage;

	private String message;

	/**
	 * Creates a new message internationalized. See {@link I18nMessage} and
	 * {@link Message}
	 * 
	 * @param category
	 *            of message
	 * @param message
	 *            link of message
	 * 
	 * @return a {@link I18nMessage}
	 */
	public I18nMessage create(Category category, final String message) {
		i18nMessage = new I18nMessage(category.name().toLowerCase(), message);
		i18nMessage.setBundle(ResourceBundle.getBundle(FILE_MESSAGE));
		return i18nMessage;
	}

	public I18nMessageCreator translate(String message) {
		this.message = message;
		return this;
	}

	public I18nMessage to(String category) {
		try {
			i18nMessage = new I18nMessage(category, message);
			i18nMessage.setBundle(ResourceBundle.getBundle(FILE_MESSAGE));
		} catch(NullPointerException npe) {
			throw new RuntimeException("Category of message has no passed!");
		}

		return i18nMessage;
	}
}
