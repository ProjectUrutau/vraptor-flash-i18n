package io.github.projecturutau.vraptor.test;

import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.util.test.MockResult;
import io.github.projecturutau.vraptor.handler.FlashMessage;
import io.github.projecturutau.vraptor.handler.Screened;

@Vetoed
public class MockFlash implements FlashMessage {

	private final MockResult mockResult;

	public MockFlash() {
		this(null);
	}
	
	public MockFlash(MockResult mockResult) {
		this.mockResult = mockResult;
	}

	@Override
	public Screened use(String category) {
		return new MockScreened(mockResult, category);
	}

	@Override
	public FlashMessage when(Boolean condition) {
		return this;
	}

}
