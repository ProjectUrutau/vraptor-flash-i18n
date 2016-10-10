package br.com.urutau.vraptor.handler;

public interface FlashMessage {
	/**
	 * Mark a context to put a message
	 *  
	 * @param context some place into views
	 * @return this Handler to calls {@link #show(String)} by chain method
	 */
	public Screened use(String category);
}