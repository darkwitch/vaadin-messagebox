package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'sl'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_sl extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "V redu"},
			{ButtonId.ABORT.toString(), "Prekini"},
			{ButtonId.CANCEL.toString(), "Prekliči"},
			{ButtonId.YES.toString(), "Da"},
			{ButtonId.NO.toString(), "Ne"},
			{ButtonId.CLOSE.toString(), "Zapri"},
			{ButtonId.SAVE.toString(), "Shrani"},
			{ButtonId.RETRY.toString(), "Poskusi znova"},
			{ButtonId.IGNORE.toString(), "Prezri"},
			{ButtonId.HELP.toString(), "Pomoč"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

