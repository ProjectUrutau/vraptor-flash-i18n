package br.com.urutau.vraptor.handler.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.enterprise.event.Event;

import org.junit.Before;
import org.junit.Test;

import io.github.projecturutau.vraptor.handler.Redirector;
import io.github.projecturutau.vraptor.handler.Screened;
import io.github.projecturutau.vraptor.handler.impl.DefaultScreened;

public class DefaultScreenedTest {

	private Redirector redirector;
	private Event<String> eventMessage;
	private Screened screened;

	@Before
	@SuppressWarnings("unchecked")
	public void setUp() {
		redirector = mock(Redirector.class);
		eventMessage = mock(Event.class);
		screened = new DefaultScreened(redirector, eventMessage);
	}

	@Test
	public void testToShow() {
		assertNotNull(screened.toShow("test"));
	}

}
