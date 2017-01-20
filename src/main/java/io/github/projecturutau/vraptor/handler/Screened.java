package io.github.projecturutau.vraptor.handler;

public interface Screened {
	/**
	 * Writes the user message after invoke a {@link #when(Boolean)} method
	 * 
	 * @param message Error message
	 */
	public Redirector toShow(String message);
}
