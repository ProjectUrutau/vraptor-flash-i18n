package br.com.urutau.vraptor.handler.impl;

import static org.junit.Assert.*;

import javax.enterprise.event.Event;

import org.junit.Before;
import org.junit.Test;

import io.github.projecturutau.vraptor.handler.FlashMessage;
import io.github.projecturutau.vraptor.handler.Screened;
import io.github.projecturutau.vraptor.handler.impl.DefaultFlash;

import static org.mockito.Mockito.*;

public class DefaultMessageHandlerTest {

	private Screened screened;
	private Event<String> eventMessage;
	private Event<Boolean> eventCondition;
	private FlashMessage handler;
	
	@Before
	@SuppressWarnings("unchecked")
	public void setUp() {
		screened = mock(Screened.class);
		eventMessage = mock(Event.class);
		eventCondition = mock(Event.class);
		handler = new DefaultFlash(screened, eventMessage, eventCondition);
	}

	@Test
	public void testUse() {
		assertNotNull(handler.use("category"));
	}

}
