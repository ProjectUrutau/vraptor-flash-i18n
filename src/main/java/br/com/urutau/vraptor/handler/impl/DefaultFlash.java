package br.com.urutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.urutau.vraptor.handler.FlashMessage;
import br.com.urutau.vraptor.handler.Screened;
import br.com.urutau.vraptor.handler.qualifier.Category;

@RequestScoped
public class DefaultFlash implements FlashMessage {

	private static final Logger logger = LoggerFactory.getLogger(DefaultFlash.class);

	private final Screened screened;
	private final Event<String> event;

	public DefaultFlash() {
		this(null, null);
	}

	@Inject
	public DefaultFlash(Screened screened, @Category Event<String> event) {
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