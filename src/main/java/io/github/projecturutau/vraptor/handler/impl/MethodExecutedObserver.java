package io.github.projecturutau.vraptor.handler.impl;

import static br.com.caelum.vraptor.controller.HttpMethod.POST;
import static br.com.caelum.vraptor.controller.HttpMethod.PUT;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.HttpMethod;
import br.com.caelum.vraptor.events.MethodExecuted;
import io.github.projecturutau.vraptor.handler.Redirector;

public class MethodExecutedObserver {

	private final HttpServletRequest currentRequest;
	private final Result result;
	private final Redirector redirector;

	public MethodExecutedObserver() {
		this(null, null, null);
	}
	
	@Inject
	public MethodExecutedObserver(HttpServletRequest request, Result result, Redirector redirector) {
		this.currentRequest = request;
		this.result = result;
		this.redirector = redirector;
	}

	/**
	 * When method has been executed if result has not been decided, 
	 * should be call {@link Redirector#stay()}
	 * 
	 * @param method Vraptor gives the method listened in this observer
	 */
	public void stay(@Observes MethodExecuted method) {
		// Stay in same page
		HttpMethod currentMethod = HttpMethod.of(currentRequest);

		if (currentMethod == POST || currentMethod == PUT) {
			if (!result.used()) {
				redirector.stay();
			}
		}
	}
}
