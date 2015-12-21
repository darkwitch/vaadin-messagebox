package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'sk'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_sk extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Prerušiť"},
			{ButtonId.CANCEL.toString(), "Zrušiť"},
			{ButtonId.YES.toString(), "Áno"},
			{ButtonId.NO.toString(), "Nie"},
			{ButtonId.CLOSE.toString(), "Zavrieť"},
			{ButtonId.SAVE.toString(), "Uložiť"},
			{ButtonId.RETRY.toString(), "Skúsiť znova"},
			{ButtonId.IGNORE.toString(), "Ignorovať"},
			{ButtonId.HELP.toString(), "Pomocník"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

