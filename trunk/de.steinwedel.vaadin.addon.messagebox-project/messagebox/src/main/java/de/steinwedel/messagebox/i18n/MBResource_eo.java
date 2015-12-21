package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'eo'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_eo extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Konfirmi"},
			{ButtonId.ABORT.toString(), "Ĉesigi"},
			{ButtonId.CANCEL.toString(), "Rezigni"},
			{ButtonId.YES.toString(), "Jes"},
			{ButtonId.NO.toString(), "Ne"},
			{ButtonId.CLOSE.toString(), "Fermi"},
			{ButtonId.SAVE.toString(), "Konsevi"},
			{ButtonId.RETRY.toString(), "Provi denove"},
			{ButtonId.IGNORE.toString(), "Malatenti"},
			{ButtonId.HELP.toString(), "Helpo"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

