package com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.urutau.vraptor.handler.Redirector;
import com.urutau.vraptor.handler.Screened;
import com.urutau.vraptor.handler.qualifier.Message;

@RequestScoped
public class DefaultScreened implements Screened {
	private static final Logger logger = LoggerFactory.getLogger(DefaultJudge.class);

	private final Redirector redirector;

	@Message
	private final Event<String> eventMessage;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultScreened() {
		this(null, null);
	}

	public DefaultScreened(Redirector redirector, Event<String> eventMessage) {
		this.redirector = redirector;
		this.eventMessage = eventMessage;
	}

	@Override
	public Redirector toShow(String message) {
		logger.info("Message: " + message);

		// Translate message and put in validator
		eventMessage.fire(message);
		// By default, should stay in the current page
		redirector.stayInCurrent();

		return redirector;
	}

}
