package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'nl'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_nl extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Afbreken"},
			{ButtonId.CANCEL.toString(), "Annuleren"},
			{ButtonId.YES.toString(), "Ja"},
			{ButtonId.NO.toString(), "Nee"},
			{ButtonId.CLOSE.toString(), "Sluiten"},
			{ButtonId.SAVE.toString(), "Opslaan"},
			{ButtonId.RETRY.toString(), "Opnieuw"},
			{ButtonId.IGNORE.toString(), "Negeren"},
			{ButtonId.HELP.toString(), "Help"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

