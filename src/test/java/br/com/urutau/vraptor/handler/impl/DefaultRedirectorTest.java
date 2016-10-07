package br.com.urutau.vraptor.handler.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.urutau.vraptor.handler.Redirector;

public class DefaultRedirectorTest {

	private Result result;
	private Redirector redirector;

	@Before
	public void setUp() {
		result = new MockResult();
		redirector = new DefaultRedirector(result);
	}

	@Test
	public void testRedirectingTo() {
		assertNotNull(redirector.redirectingTo(Object.class));
	}
	
	@Test
	public void testStay() {
		redirector.stay();
		assertTrue(result.used());
	}
}
