package br.com.urutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.urutau.vraptor.handler.Redirector;

@Vetoed
public class MockRedirector implements Redirector {
	private MockResult mockResult = new MockResult();

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
