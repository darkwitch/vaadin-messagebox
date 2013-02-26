package de.steinwedel.messagebox;

import java.io.Serializable;
import java.util.HashMap;

import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

/**
 * Manages the loading of default resources. You can override the method <code>getIcon</code> to use customized icons.
 * The overridden <code>DefaultResources</code> must be set to the static member <code>DEFAULT_RESOURCES</code> of the class <code>MessageBox</code>.
 * You can set localized captions for the buttons by replacing the values inside the map <code>BUTTON_CAPTION</code>. 
 * 
 * @author Dieter Steinwedel
 */
public class DefaultResources implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static HashMap<ButtonId, String> BUTTON_CAPTION = new HashMap<ButtonId, String>();
	
	static {
		BUTTON_CAPTION.put(ButtonId.OK, "Ok");
		BUTTON_CAPTION.put(ButtonId.ABORT, "Abort");
		BUTTON_CAPTION.put(ButtonId.CANCEL, "Cancel");
		BUTTON_CAPTION.put(ButtonId.YES, "Yes");
		BUTTON_CAPTION.put(ButtonId.NO, "No");
		BUTTON_CAPTION.put(ButtonId.CLOSE, "Close");
		BUTTON_CAPTION.put(ButtonId.SAVE, "Save");
		BUTTON_CAPTION.put(ButtonId.RETRY, "Retry");
		BUTTON_CAPTION.put(ButtonId.IGNORE, "Ignore");
		BUTTON_CAPTION.put(ButtonId.HELP, "Help");
		BUTTON_CAPTION.put(ButtonId.CUSTOM_1, "Custom 1");
		BUTTON_CAPTION.put(ButtonId.CUSTOM_2, "Custom 2");
		BUTTON_CAPTION.put(ButtonId.CUSTOM_3, "Custom 3");
		BUTTON_CAPTION.put(ButtonId.CUSTOM_4, "Custom 4");
		BUTTON_CAPTION.put(ButtonId.CUSTOM_5, "Custom 5");
	}
	
	/**
	 * Returns the specified icon as resource.
	 * @param icon				The requested icon
	 * @return					The loaded icon
	 */
	public Resource getIcon(Icon icon) {
		switch (icon) {
		case QUESTION:
			return new ClassResource(DefaultResources.class, "icons/question.png");
		case INFO:
			return new ClassResource(DefaultResources.class, "icons/info.png");
		case WARN:
			return new ClassResource(DefaultResources.class, "icons/warn.png");
		case ERROR:
			return new ClassResource(DefaultResources.class, "icons/error.png");
		default:
			return null;
		}
	}
	
	/**
	 * Returns to the specified buttonId a corresponding resource.
	 * @param buttonId			The buttonId
	 * @return					The corresponding icon to the buttonId
	 */
	public Resource getIcon(ButtonId buttonId) {
		switch (buttonId) {
		case OK:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/tick.png");
		case ABORT:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/cross.png");
		case CANCEL:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/cross.png");
		case YES:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/tick.png");
		case NO:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/cross.png");
		case CLOSE:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/door.png");
		case SAVE:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/disk.png");
		case RETRY:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/arrow_refresh.png");
		case IGNORE:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/lightning_go.png");
		case HELP:
			return new ClassResource(DefaultResources.class, "icons/famfamfam/lightbulb.png");
		default:
			return null;
		}
	}
	
	/**
	 * Returns to the specified buttonId a corresponding resource.
	 * @param buttonId			The buttonId
	 * @return					The corresponding icon to the buttonId
	 */
	public Component getButton(ButtonId buttonId) {
		if (buttonId == null) throw new NullPointerException("The buttonId should not be null.");
				
		if (ButtonId.SPACER.equals(buttonId)) {
			return new Label("&nbsp;", ContentMode.HTML);
		} else {
			Button result = new Button();
			result.setImmediate(true);
			result.setData(buttonId);
			result.setIcon(getIcon(buttonId));
			result.setCaption(BUTTON_CAPTION.get(buttonId));
			return result;
		}
	}

}
