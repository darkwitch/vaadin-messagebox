package de.steinwedel.messagebox;

/**
 * An enumeration for identifying the nature of the button. The ButtonId is used inside then Eventlistener. 
 * 
 * @author Dieter Steinwedel
 */
public enum ButtonId {

	/**
	 * Self-explaining.
	 */
	OK,
	
	/**
	 * Self-explaining.
	 */
	ABORT,
	
	/**
	 * Self-explaining.
	 */
	CANCEL,
	
	/**
	 * Self-explaining.
	 */
	YES,
	
	/**
	 * Self-explaining.
	 */
	NO,
	
	/**
	 * Self-explaining.
	 */
	CLOSE,
	
	/**
	 * Self-explaining.
	 */
	SAVE,
	
	/**
	 * Self-explaining.
	 */
	RETRY,
	
	/**
	 * Self-explaining.
	 */
	IGNORE,
	
	/**
	 * Self-explaining. Keep in mind, that the window will not be closed, if this value is received!
	 */
	HELP,
	
	/**
	 * Use this, if you want to use a custom named and styled button.
	 */
	CUSTOM_1,
	
	/**
	 * Use this, if you want to use a custom named and styled button.
	 */
	CUSTOM_2,
	
	/**
	 * Use this, if you want to use a custom named and styled button.
	 */
	CUSTOM_3,
	
	/**
	 * Use this, if you want to use a custom named and styled button.
	 */
	CUSTOM_4,
	
	/**
	 * Use this, if you want to use a custom named and styled button.
	 */
	CUSTOM_5,
	
	/**
	 * Use this, if you want to increase the padding between two buttons.
	 */
	SPACER
	
}
