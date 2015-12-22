package de.steinwedel.messagebox.icons;

import java.io.Serializable;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.Embedded;

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
public abstract class DialogIconFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Class<?> associatedClass;
	protected String relativePath;
	
	/**
	 * TODO
	 * @param associatedClass
	 * @param relativePath
	 */
	public DialogIconFactory(Class<?> associatedClass, String relativePath) {
		this.associatedClass = associatedClass;
		this.relativePath = relativePath;
	}

	/**
	 * TODO
	 */
	public Embedded getQuestionIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/question.png"));
	}
	
	/**
	 * TODO
	 */
	public Embedded getInfoIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/info.png"));
	}
	
	/**
	 * TODO
	 */
	public Embedded getWarningIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/warn.png"));
	}
	
	/**
	 * TODO
	 */
	public Embedded getErrorIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/error.png"));
	}
			
}
