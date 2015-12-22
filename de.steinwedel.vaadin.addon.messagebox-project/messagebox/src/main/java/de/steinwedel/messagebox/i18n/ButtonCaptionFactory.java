package de.steinwedel.messagebox.i18n;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import com.vaadin.server.VaadinService;

import de.steinwedel.messagebox.ButtonType;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.i18n.captions.ButtonCaptions;

/**
 * Manages the loading of default resources like icons and button captions. You can override the method <code>getIcon</code> to use customized icons.
 * The overridden <code>DefaultResources</code> must be set to the static member {@link MessageBox#RESOURCE_FACTORY}.
 * You can change the default captions of the buttons by using a different {@link java.util.ResourceBundle}. 
 * You can assign the new {@link java.util.ResourceBundle} with the method {@link #setResourceBundle(java.lang.String)} or {@link #setResourceBundle(java.lang.String, java.util.Locale)} . 
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptionFactory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String LANGUAGE_SESSION_KEY = "messagebox_language";
	
	public String translate(ButtonType buttonCaptionKey, Locale defaultLocale) {
		if (buttonCaptionKey == null) {
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
		return resourceBundle.getString(buttonCaptionKey.name());
	}
		
}