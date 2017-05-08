package io.github.projecturutau.vraptor.handler;

public interface FlashMessage {
	/**
	 * Mark a context to put a message
	 *  
	 * @param category refers to some place into views
	 * @return this Handler to calls {@link io.github.projecturutau.vraptor.handler.Screened#toShow(String)} by chain method
	 */
	public Screened use(String category);
	
	/**
	 * Condition to shows the message
	 * 
	 * @param condition is to evaluate if message should be included
	 * @return self object
	 */
	public FlashMessage when(Boolean condition);
}