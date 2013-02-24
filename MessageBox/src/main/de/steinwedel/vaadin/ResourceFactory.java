package de.steinwedel.vaadin;

import java.io.Serializable;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;

/**
 * Manages the loading of icon resources. You can override the method <code>loadResource</code> to use customized icons.
 * The new <code>ResourceFactory</code> must be set to the static member <code>RESOURCE_FACTORY</code> of the class <code>MessageBox</code>.
 * 
 * @author Dieter Steinwedel
 */
public class ResourceFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * A enumeration with named resources.
	 * 
	 * @author Dieter Steinwedel
	 */
	public static enum IconResource {
		QUESTION,
		INFO,
		WARN,
		ERROR,
		OK,
		ABORT,
		CANCEL,
		YES,
		NO,
		CLOSE,
		SAVE,
		RETRY,
		IGNORE,
		HELP,
		CUSTOM1,
		CUSTOM2,
		CUSTOM3,
		CUSTOM4,
		CUSTOM5
	}
	
	/**
	 * Loads the specified icon for the application.
	 * @param icon				The requested icon
	 * @return					The loaded icon
	 */
	public Resource loadResource(IconResource icon) {
		switch (icon) {
		case QUESTION:
			return new ClassResource(ResourceFactory.class, "images/question.png");
		case INFO:
			return new ClassResource(ResourceFactory.class, "images/info.png");
		case WARN:
			return new ClassResource(ResourceFactory.class, "images/warn.png");
		case ERROR:
			return new ClassResource(ResourceFactory.class, "images/error.png");
		case OK:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/tick.png");
		case ABORT:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png");
		case CANCEL:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png");
		case YES:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/tick.png");
		case NO:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png");
		case CLOSE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/door.png");
		case SAVE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/disk.png");
		case RETRY:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/arrow_refresh.png");
		case IGNORE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/lightning_go.png");
		case HELP:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/lightbulb.png");
		default:
			return null;
		}
	}

}
