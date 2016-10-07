package br.com.urutau.vraptor.handler.error;

import br.com.urutau.vraptor.handler.Screened;

public interface Judge {
	/**
	 * Sets a condition to throws an specific error
	 * 
	 * @param condition true to message be showed
	 * @return {@link Screened} to writes a message
	 */
	Screened when(Boolean condition);
}
