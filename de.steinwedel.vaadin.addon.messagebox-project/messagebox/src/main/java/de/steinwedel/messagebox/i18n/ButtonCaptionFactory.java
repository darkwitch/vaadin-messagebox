package de.steinwedel.messagebox.i18n;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.server.VaadinService;

import de.steinwedel.messagebox.ButtonType;
import de.steinwedel.messagebox.i18n.captions.ButtonCaptions;

/**
 * Manages the translation of button captions. 
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptionFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String LANGUAGE_SESSION_KEY = "messagebox_language";
	
	/**
	 * Translates the caption for the given buttonType.
	 * 
	 * @param buttonType
	 * @param defaultLocale
	 * 
	 * @return The translated caption
	 */
	public String translate(ButtonType buttonType, Locale defaultLocale) {
		if (buttonType == null) {
			return "";
		}
		
		String basename = ButtonCaptions.class.getName();
		
		Locale locale = defaultLocale;
		Object value = VaadinService.getCurrentRequest().getWrappedSession().getAttribute(LANGUAGE_SESSION_KEY);
		if (value != null && value instanceof Locale) {
			locale = (Locale) value;
		}
		
		ResourceBundle resourceBundle = null;
		try {
			resourceBundle = ResourceBundle.getBundle(basename, locale);
		} catch(Throwable t) {
			resourceBundle = ResourceBundle.getBundle(basename, Locale.ENGLISH);
		}
		return resourceBundle.getString(buttonType.name());
	}
		
}