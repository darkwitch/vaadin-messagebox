package de.steinwedel.messagebox.icons;

import java.io.Serializable;

import com.vaadin.server.Resource;

import de.steinwedel.messagebox.ButtonType;

/**
 * This interface defines the essential methods for a ButtonIconFactory  
 * 
 * @author Dieter Steinwedel
 */
public interface ButtonIconFactory extends Serializable {
	
	/**
	 * Loads the resource for the given buttonType.
	 * 
	 * @param buttonType The ButtonType
	 * @return The resource
	 */
	public Resource getIcon(ButtonType buttonType);
	
}