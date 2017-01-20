package io.github.projecturutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import io.github.projecturutau.vraptor.handler.FlashMessage;
import io.github.projecturutau.vraptor.handler.Screened;

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
