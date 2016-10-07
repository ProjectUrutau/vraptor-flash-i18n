package br.com.urutau.vraptor.handler.impl.error;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.urutau.vraptor.handler.Screened;
import br.com.urutau.vraptor.handler.error.Judge;
import br.com.urutau.vraptor.handler.qualifier.Condition;

@RequestScoped
public class DefaultJudge implements Judge {

	private static final Logger logger = LoggerFactory.getLogger(DefaultJudge.class);

	private final Screened screened;

	@Condition
	private final Event<Boolean> eventCondition;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultJudge() {
		this(null, null);
	}

	@Inject
	public DefaultJudge(Screened screened, Event<Boolean> event) {
		this.screened = screened;
		this.eventCondition = event;
	}

	@Override
	public Screened when(Boolean conditionToShow) {
		logger.info("Show message is " + conditionToShow);
		eventCondition.fire(conditionToShow);
		return screened;
	}

}
