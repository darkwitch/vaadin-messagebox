package de.steinwedel.messagebox.icons;

import java.io.Serializable;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;

import de.steinwedel.messagebox.ButtonType;
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
public abstract class ButtonIconFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Class<?> associatedClass;
	protected String relativePath;
	
	/**
	 * TODO
	 * @param associatedClass
	 * @param relativePath
	 */
	public ButtonIconFactory(Class<?> associatedClass, String relativePath) {
		this.associatedClass = associatedClass;
		this.relativePath = relativePath;
	}
	
	public Resource getIcon(ButtonType buttonType) {
		if (buttonType == null) {
			return null;
		}
		switch (buttonType) {
		case ABORT:
		case CANCEL:
		case NO:
			return new ClassResource(associatedClass, relativePath + "/cross.png");
		case OK:
		case YES:
			return new ClassResource(associatedClass, relativePath + "/tick.png");
		case SAVE:
			return new ClassResource(associatedClass, relativePath + "/disk.png");	
		case HELP:	
			return new ClassResource(associatedClass, relativePath + "/lightbulb.png");
		case IGNORE:
			return new ClassResource(associatedClass, relativePath + "/lightning_go.png");	
		case RETRY:
			return new ClassResource(associatedClass, relativePath + "/arrow_refresh.png");	
		case CLOSE:
			return new ClassResource(associatedClass, relativePath + "/door.png");
		default:
			return null;
		}
	}
	
}