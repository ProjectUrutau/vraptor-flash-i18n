package com.urutau.vraptor.handler.impl;

import static br.com.caelum.vraptor.controller.HttpMethod.POST;
import static br.com.caelum.vraptor.controller.HttpMethod.PUT;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.urutau.vraptor.handler.Redirector;
import com.urutau.vraptor.handler.Screened;
import com.urutau.vraptor.handler.qualifier.Message;

import br.com.caelum.vraptor.controller.HttpMethod;;

@RequestScoped
public class DefaultScreened implements Screened {
	private static final Logger logger = LoggerFactory.getLogger(DefaultJudge.class);

	private final Redirector redirector;
	private final HttpServletRequest currentRequest;
	private final Event<String> eventMessage;

	/**
	 * @deprecated CDI eyes only
	 */
	public DefaultScreened() {
		this(null, null, null);
	}
	
	@Inject
	public DefaultScreened(Redirector redirector, HttpServletRequest request, 
			@Message Event<String> eventMessage) {
		this.redirector = redirector;
		this.currentRequest = request;
		this.eventMessage = eventMessage;
	}

	@Override
	public Redirector toShow(String message) {
		logger.info("Message: " + message);

		// Translate message and put in validator
		eventMessage.fire(message);
		// Stay in same page
		HttpMethod currentMethod = HttpMethod.of(currentRequest);
		if( currentMethod == POST || currentMethod == PUT) {
			redirector.stayInCurrent();
		}
		
		return redirector;
	}

}
