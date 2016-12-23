package br.com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.urutau.vraptor.handler.Redirector;

@RequestScoped
public class DefaultRedirector implements Redirector {
	private static final Logger logger = LoggerFactory.getLogger(DefaultRedirector.class);

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultRedirector() {
		this(null);
	}

	@Inject
	public DefaultRedirector(Result result) {
		this.result = result;
	}

	@Override
	public <Controller> Controller redirectTo(Class<Controller> controller) {
		logger.debug("redirecting...");
		return result.redirectTo((controller));
	}

	@Override
	public void sendJSON() {
		result.use(Results.json()).withoutRoot().from(result.included()).serialize();
	}

	@Override
	public void stay() {
		logger.debug("Stay in same page");
		result.use(Results.referer()).redirect();
	}
}
