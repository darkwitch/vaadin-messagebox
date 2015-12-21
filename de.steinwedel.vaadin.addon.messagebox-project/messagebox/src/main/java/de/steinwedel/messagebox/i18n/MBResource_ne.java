package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ne'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ne extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "ठीक छ"},
			{ButtonId.ABORT.toString(), "परित्याग गर्नुहोस्"},
			{ButtonId.CANCEL.toString(), "रद्द गर्नुहोस्"},
			{ButtonId.YES.toString(), "हो"},
			{ButtonId.NO.toString(), "होइन"},
			{ButtonId.CLOSE.toString(), "Lukk"},
			{ButtonId.SAVE.toString(), "Lagre"},
			{ButtonId.RETRY.toString(), "Prøv igjen"},
			{ButtonId.IGNORE.toString(), "Ignorer"},
			{ButtonId.HELP.toString(), "Hjelp"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

