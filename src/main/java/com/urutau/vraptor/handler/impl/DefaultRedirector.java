package com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.urutau.vraptor.handler.Redirector;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@RequestScoped
public class DefaultRedirector implements Redirector {
	private static final Logger logger = LoggerFactory.getLogger(DefaultRedirector.class);

	private final Result result;
	private final Validator validator;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultRedirector() {
		this(null, null);
	}

	public DefaultRedirector(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Override
	public void sendJSON() {
		logger.info("Send a json with " + validator.getErrors().size() + " errors");

		validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
	}

	@Override
	public <Controller> Controller redirectingTo(Class<Controller> controller) {
		return validator.onErrorRedirectTo(controller);
	}

	@Override
	public <Controller> Controller onErrorUsePageOf(Class<Controller> controller) {
		return validator.onErrorUsePageOf(controller);
	}

	@Override
	public void stayInCurrent() {
		result.use(Results.referer()).redirect();
	}
}
