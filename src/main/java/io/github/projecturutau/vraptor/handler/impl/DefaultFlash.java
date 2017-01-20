package io.github.projecturutau.vraptor.handler.impl;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.projecturutau.vraptor.handler.FlashMessage;
import io.github.projecturutau.vraptor.handler.Screened;
import io.github.projecturutau.vraptor.handler.qualifier.Category;
import io.github.projecturutau.vraptor.handler.qualifier.Condition;

@RequestScoped
public class DefaultFlash implements FlashMessage {

	private static final Logger logger = LoggerFactory.getLogger(DefaultFlash.class);

	private final Screened screened;
	private final Event<String> eventMessage;
	private final Event<Boolean> eventCondition;

	public DefaultFlash() {
		this(null, null, null);
	}

	@Inject
	public DefaultFlash(Screened screened, @Category Event<String> eventMessage,
			@Condition Event<Boolean> eventCondition) {
		this.screened = screened;
		this.eventMessage = eventMessage;
		this.eventCondition = eventCondition;
	}

	@Override
	public Screened use(String category) {
		logger.info("Category " + category + " was selected");
		eventMessage.fire(category);
		return screened;
	}

	@Override
	public FlashMessage when(Boolean condition) {
		logger.debug("Condition to show message has " + condition);
		eventCondition.fire(condition);
		return this;
	}
}