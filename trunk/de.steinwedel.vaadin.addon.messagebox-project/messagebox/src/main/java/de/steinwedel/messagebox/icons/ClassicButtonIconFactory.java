package de.steinwedel.messagebox.icons;

import de.steinwedel.messagebox.MessageBox;

/**
 * TODO
 * Manages the loading of default resources like icons and button captions. You can override the method <code>getIcon</code> to use customized icons.
 * The overridden <code>DefaultResources</code> must be set to the static member {@link MessageBox#RESOURCE_FACTORY}.
 * You can change the default captions of the buttons by using a different {@link java.util.ResourceBundle}. 
 * You can assign the new {@link java.util.ResourceBundle} with the method {@link #setResourceBundle(java.lang.String)} or {@link #setResourceBundle(java.lang.String, java.util.Locale)} . 
 * 
 * @author Dieter Steinwedel
 */
public class ClassicButtonIconFactory extends ButtonIconFactory {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor.
	 */
	public ClassicButtonIconFactory() {
		super(ClassicButtonIconFactory.class, "classic/button");
	}
		
}
