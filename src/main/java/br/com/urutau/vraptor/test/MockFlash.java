package br.com.urutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.urutau.vraptor.handler.FlashMessage;
import br.com.urutau.vraptor.handler.Screened;

@Vetoed
public class MockFlash implements FlashMessage {

	@Override
	public Screened use(String category) {
		return new MockScreened();
	}

	@Override
	public FlashMessage when(Boolean condition) {
		return this;
	}

}
