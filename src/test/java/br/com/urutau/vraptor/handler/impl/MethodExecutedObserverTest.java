package br.com.urutau.vraptor.handler.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.events.MethodExecuted;
import br.com.caelum.vraptor.util.test.MockResult;
import io.github.projecturutau.vraptor.handler.Redirector;
import io.github.projecturutau.vraptor.handler.impl.MethodExecutedObserver;

public class MethodExecutedObserverTest {

	private MethodExecutedObserver observer;
	private MethodExecuted methodExecuted;
	private HttpServletRequest currentRequest;
	private Result result;
	private Redirector redirector;

	@Before
	public void setUp() {
		currentRequest = mock(HttpServletRequest.class);
		redirector = mock(Redirector.class);
		result = new MockResult();
		when(currentRequest.getParameter("_method"));
		observer = new MethodExecutedObserver(currentRequest, result, redirector);
	}

	@Test
	@Ignore("Hole crap! This calls a static method")
	public void testWithGET() {
		observer.stay(methodExecuted);
	}

}
