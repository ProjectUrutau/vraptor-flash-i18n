package br.com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.urutau.vraptor.handler.Redirector;
import br.com.urutau.vraptor.handler.Screened;
import br.com.urutau.vraptor.handler.qualifier.Message;;

@RequestScoped
public class DefaultScreened implements Screened {
	private static final Logger logger = LoggerFactory.getLogger(DefaultScreened.class);

	private final Redirector redirector;
	private final Event<String> eventMessage;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultScreened() {
		this(null, null);
	}

	@Inject
	public DefaultScreened(Redirector redirector, @Message Event<String> eventMessage) {
		this.redirector = redirector;
		this.eventMessage = eventMessage;
	}

	@Override
	public Redirector toShow(String message) {
		logger.info("Message: " + message);

		// Translate message and put in validator
		eventMessage.fire(message);

		return redirector;
	}
}
