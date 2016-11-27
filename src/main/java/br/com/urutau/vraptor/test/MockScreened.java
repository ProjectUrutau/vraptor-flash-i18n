package br.com.urutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.urutau.vraptor.handler.Redirector;
import br.com.urutau.vraptor.handler.Screened;

@Vetoed
public class MockScreened implements Screened {

	@Override
	public Redirector toShow(String message) {
		return new MockRedirector();
	}

}
