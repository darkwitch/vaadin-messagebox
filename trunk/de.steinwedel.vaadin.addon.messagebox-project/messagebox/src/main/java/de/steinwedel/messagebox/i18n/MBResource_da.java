package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'da'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_da extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "O.k."},
			{ButtonId.ABORT.toString(), "Afbryd"},
			{ButtonId.CANCEL.toString(), "Annullér"},
			{ButtonId.YES.toString(), "Ja"},
			{ButtonId.NO.toString(), "Nej"},
			{ButtonId.CLOSE.toString(), "Luk"},
			{ButtonId.SAVE.toString(), "Gem"},
			{ButtonId.RETRY.toString(), "Forsøg igen"},
			{ButtonId.IGNORE.toString(), "Ignorér"},
			{ButtonId.HELP.toString(), "Hjælp"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

