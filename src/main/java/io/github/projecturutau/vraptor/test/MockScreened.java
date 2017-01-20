package io.github.projecturutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import io.github.projecturutau.vraptor.handler.Redirector;
import io.github.projecturutau.vraptor.handler.Screened;

@Vetoed
public class MockScreened implements Screened {

	@Override
	public Redirector toShow(String message) {
		return new MockRedirector();
	}

}
