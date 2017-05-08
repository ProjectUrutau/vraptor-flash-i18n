package io.github.projecturutau.vraptor.handler;

public interface Screened {
	/**
	 * Writes the user message after invoke a {see FlashError#when(Boolean)} method
	 * 
	 * @param message Error message
	 * @return {@link Redirector} that decide where go
	 */
	public Redirector toShow(String message);
}
