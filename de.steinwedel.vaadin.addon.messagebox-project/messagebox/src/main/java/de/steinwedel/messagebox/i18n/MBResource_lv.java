package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'lv'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_lv extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Labi"},
			{ButtonId.ABORT.toString(), "Pārtraukt"},
			{ButtonId.CANCEL.toString(), "Atcelt"},
			{ButtonId.YES.toString(), "Jā"},
			{ButtonId.NO.toString(), "Nē"},
			{ButtonId.CLOSE.toString(), "Aizvērt"},
			{ButtonId.SAVE.toString(), "Saglabāt"},
			{ButtonId.RETRY.toString(), "Mēģināt vēlreiz"},
			{ButtonId.IGNORE.toString(), "Ignorēt"},
			{ButtonId.HELP.toString(), "Palīdzība"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

