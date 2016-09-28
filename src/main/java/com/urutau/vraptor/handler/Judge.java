package com.urutau.vraptor.handler;

public interface Judge {
	/**
	 * Sets a condition to throws an specific error
	 * 
	 * @param condition true to message be showed
	 * @return {@link Screened} to writes a message
	 */
	Screened when(Boolean condition);
}
