package io.github.projecturutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.util.test.MockResult;
import io.github.projecturutau.vraptor.handler.Redirector;
import io.github.projecturutau.vraptor.handler.Screened;

@Vetoed
public class MockScreened implements Screened {
	private final MockResult mockResult;
	private final String key;
	
	public MockScreened(MockResult mockResult, String key) {
		this.mockResult = mockResult;
		this.key = key;
	}

	@Override
	public Redirector toShow(String message) {
		return new MockRedirector(mockResult, key, message);
	}
}
