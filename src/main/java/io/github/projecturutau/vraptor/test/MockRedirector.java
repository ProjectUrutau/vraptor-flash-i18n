package io.github.projecturutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.util.test.MockResult;
import io.github.projecturutau.vraptor.handler.Redirector;

@Vetoed
public class MockRedirector implements Redirector {
	private final MockResult mockResult;

	public MockRedirector(MockResult mockResult, String key, String message) {
		this.mockResult = mockResult;
		mockResult.include(key, message);
	}

	/*
	 * Whatever with this effect
	 */
	
	@Override
	public <Controller> Controller redirectTo(Class<Controller> controller) {
		return mockResult.redirectTo(controller);
	}

	@Override
	public void sendJSON() {
	}

	@Override
	public void stay() {
	}

}
