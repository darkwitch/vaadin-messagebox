package de.steinwedel.messagebox.i18n.captions;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonType;

/**
 * I18n for the button captions. This class contains the translations for language code 'nb'.
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptions_nb extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonType.OK.name(), "OK"},
			{ButtonType.ABORT.name(), "Avbryt"},
			{ButtonType.CANCEL.name(), "Avbryt"},
			{ButtonType.YES.name(), "Ja"},
			{ButtonType.NO.name(), "Nei"},
			{ButtonType.CLOSE.name(), "Lukk"},
			{ButtonType.SAVE.name(), "Lagre"},
			{ButtonType.RETRY.name(), "Prøv igjen"},
			{ButtonType.IGNORE.name(), "Ignorer"},
			{ButtonType.HELP.name(), "Hjelp"},
		};
	}

}

