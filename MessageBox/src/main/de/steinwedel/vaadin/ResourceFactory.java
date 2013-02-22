package de.steinwedel.vaadin;

import java.io.Serializable;

import com.vaadin.Application;
import com.vaadin.terminal.ClassResource;
import com.vaadin.terminal.Resource;

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
	 * @param application		The application, where the icon is used
	 * @return					The loaded icon
	 */
	public Resource loadResource(IconResource icon, Application application) {
		switch (icon) {
		case QUESTION:
			return new ClassResource(ResourceFactory.class, "images/question.png", application);
		case INFO:
			return new ClassResource(ResourceFactory.class, "images/info.png", application);
		case WARN:
			return new ClassResource(ResourceFactory.class, "images/warn.png", application);
		case ERROR:
			return new ClassResource(ResourceFactory.class, "images/error.png", application);
		case OK:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/tick.png", application);
		case ABORT:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png", application);
		case CANCEL:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png", application);
		case YES:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/tick.png", application);
		case NO:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/cross.png", application);
		case CLOSE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/door.png", application);
		case SAVE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/disk.png", application);
		case RETRY:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/arrow_refresh.png", application);
		case IGNORE:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/lightning_go.png", application);
		case HELP:
			return new ClassResource(ResourceFactory.class, "images/famfamfam/lightbulb.png", application);
		default:
			return null;
		}
	}

}
