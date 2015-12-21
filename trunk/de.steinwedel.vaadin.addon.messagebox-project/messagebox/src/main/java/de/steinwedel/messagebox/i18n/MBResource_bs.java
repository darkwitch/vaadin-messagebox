package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'bs'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_bs extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "U redu"},
			{ButtonId.ABORT.toString(), "Obustavi"},
			{ButtonId.CANCEL.toString(), "Odustani"},
			{ButtonId.YES.toString(), "Da"},
			{ButtonId.NO.toString(), "Ne"},
			{ButtonId.CLOSE.toString(), "Zatvori"},
			{ButtonId.SAVE.toString(), "Snimi"},
			{ButtonId.RETRY.toString(), "Pokušaj ponovo"},
			{ButtonId.IGNORE.toString(), "Ignoriši"},
			{ButtonId.HELP.toString(), "Pomoć"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

