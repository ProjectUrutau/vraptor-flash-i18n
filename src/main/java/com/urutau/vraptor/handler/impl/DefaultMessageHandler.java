package com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.urutau.vraptor.Category;
import com.urutau.vraptor.i18n.I18nMessageCreator;

import br.com.caelum.vraptor.Result;

@RequestScoped
public class DefaultMessageHandler {
	private final Result result;
	private final I18nMessageCreator i18n;

	private Category currentContext;

	public DefaultMessageHandler() {
		this(null, null);
	}

	@Inject
	public DefaultMessageHandler(Result result, I18nMessageCreator i18n) {
		this.result = result;
		this.i18n = i18n;
	}

	/**
	 * Mark a context to put a message
	 *  
	 * @param context some place into views
	 * @return this Handler to calls {@link #show(String)} by chain method
	 */
	public DefaultMessageHandler use(Category context) {
		this.currentContext = context;
		return this;
	}

//	/**
//	 * Shows a translated message into some {@link ContextPlace}
//	 *  
//	 * @param message reference to translate
//	 */
//	public DefaultMessageHandler show(String message) {
//		String translatedMessage = i18n.translate(message).to(currentContext).getMessage();
//		result.include(currentContext.toString(), translatedMessage);
//		return this;
//	}
//
//	/**
//	 * Uses {@link Result#redirectingTo(Class)} and redirects to another action
//	 * 
//	 * @param controller contains action that will be called
//	 * @return {@link br.com.caelum.vraptor.Controller} to calls some page
//	 */
//	public <Controller> Controller redirectTo(Class<Controller> controller) {
//		return result.redirectTo(controller);
//	}
//
//	/**
//	 * Send a result in JSON format
//	 */
//	public void sendViaJSON(String message) {
//		String translatedMessage = i18n.translate(message).to(currentContext).getMessage();
//		result.use(Results.json()).withoutRoot().from(translatedMessage).serialize();
//	}

	/**
	 * When catch an Exception return this interface to some treat
	 *  
	 * @param exception passed by other layer of architecture
	 * @return this
	 */
	public DefaultMessageHandler whenCatch(Class<? extends Exception> exception) {
		result.on(exception);
		return this;
	}

	public boolean containsMessageOf(Category projectPanel) {
		return result.included().containsKey(projectPanel.toString());
	}
}