package de.steinwedel.messagebox.icons;

import java.io.Serializable;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.Embedded;

/**
 * This class implements the default behavior for loading icons for the dialog. You can
 * override this class to apply an own icon set. 
 * 
 * @author Dieter Steinwedel
 */
public abstract class DialogIconFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Class<?> associatedClass;
	protected String relativePath;
	protected String extention;
	
	/**
	 * The constructor
	 * 
	 * @param associatedClass The associated class for loading the resources
	 * @param relativePath The relative path to the resources starting from the associated class
	 * @param extention The file extention of the images f.e. "png" or "svg"
	 */
	public DialogIconFactory(Class<?> associatedClass, String relativePath, String extention) {
		this.associatedClass = associatedClass;
		this.relativePath = relativePath;
		this.extention = extention;
	}

	/**
	 * Returns the question icon.
	 * 
	 * @return question icon
	 */
	public Embedded getQuestionIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/question." + extention));
	}
	
	/**
	 * Returns the info icon.
	 * 
	 * @return info icon
	 */
	public Embedded getInfoIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/info." + extention));
	}
	
	/**
	 * Returns the warning icon.
	 * 
	 * @return warning icon
	 */
	public Embedded getWarningIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/warning." + extention));
	}
	
	/**
	 * Returns teh error icon.
	 * 
	 * @return error icon
	 */
	public Embedded getErrorIcon() {
		return new Embedded(null, new ClassResource(associatedClass, relativePath + "/error." + extention));
	}
			
}
