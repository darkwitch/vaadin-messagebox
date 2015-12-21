package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ro'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ro extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Anulare"},
			{ButtonId.CANCEL.toString(), "Renunță"},
			{ButtonId.YES.toString(), "Da"},
			{ButtonId.NO.toString(), "Nu"},
			{ButtonId.CLOSE.toString(), "Închide"},
			{ButtonId.SAVE.toString(), "Salvează"},
			{ButtonId.RETRY.toString(), "Reîncercare"},
			{ButtonId.IGNORE.toString(), "Ignoră"},
			{ButtonId.HELP.toString(), "Ajutor"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

