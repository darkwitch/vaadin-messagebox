package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'pl'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_pl extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Przerwij"},
			{ButtonId.CANCEL.toString(), "Anuluj"},
			{ButtonId.YES.toString(), "Tak"},
			{ButtonId.NO.toString(), "Nie"},
			{ButtonId.CLOSE.toString(), "Zamknij"},
			{ButtonId.SAVE.toString(), "Zapisz"},
			{ButtonId.RETRY.toString(), "Powtórz"},
			{ButtonId.IGNORE.toString(), "Pomiń"},
			{ButtonId.HELP.toString(), "Pomoc"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

