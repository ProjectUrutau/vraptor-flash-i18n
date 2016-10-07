package br.com.urutau.vraptor.handler.impl;

import static org.junit.Assert.*;

import javax.enterprise.event.Event;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import br.com.urutau.vraptor.handler.MessageHandler;
import br.com.urutau.vraptor.handler.Screened;

public class DefaultMessageHandlerTest {

	private Screened screened;
	private Event<String> event;
	private MessageHandler handler;
	
	@Before
	@SuppressWarnings("unchecked")
	public void setUp() {
		screened = mock(Screened.class);
		event = mock(Event.class);
		handler = new DefaultMessageHandler(screened, event);
	}

	@Test
	public void testUse() {
		assertNotNull(handler.use("category"));
	}

}
