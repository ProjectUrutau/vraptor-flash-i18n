package com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.urutau.vraptor.handler.MessageHandler;
import com.urutau.vraptor.handler.Screened;
import com.urutau.vraptor.handler.qualifier.Category;

@RequestScoped
public class DefaultMessageHandler implements MessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(DefaultMessageHandler.class);

	private final Screened screened;
	private final Event<String> event;

	public DefaultMessageHandler() {
		this(null, null);
	}

	@Inject
	public DefaultMessageHandler(Screened screened, @Category Event<String> event) {
		this.screened = screened;
		this.event = event;
	}

	@Override
	public Screened use(String category) {
		logger.info("Category " + category + " was selected");
		event.fire(category);
		return screened;
	}
}