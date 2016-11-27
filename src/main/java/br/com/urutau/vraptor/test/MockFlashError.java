package br.com.urutau.vraptor.test;
import javax.enterprise.inject.Vetoed;

import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.urutau.vraptor.handler.FlashError;

@Vetoed
public class MockFlashError implements FlashError {

	private Validator validator = new MockValidator();

	@Override
	public void validate(String category) {
		// Stub method
	}

	@Override
	public Validator add(String message) {
		return validator.add(new SimpleMessage("mockMessage", message));
	}

	@Override
	public Validator getValidator() {
		return validator;
	}

}
