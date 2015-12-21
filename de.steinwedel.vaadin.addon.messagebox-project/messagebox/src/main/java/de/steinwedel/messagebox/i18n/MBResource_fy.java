package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'fy'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_fy extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Yn oarder"},
			{ButtonId.ABORT.toString(), "Keskeytä"},
			{ButtonId.CANCEL.toString(), "Peru"},
			{ButtonId.YES.toString(), "Kyllä"},
			{ButtonId.NO.toString(), "Ei"},
			{ButtonId.CLOSE.toString(), "Sulje"},
			{ButtonId.SAVE.toString(), "Tallenna"},
			{ButtonId.RETRY.toString(), "Yritä uudelleen"},
			{ButtonId.IGNORE.toString(), "Ohita"},
			{ButtonId.HELP.toString(), "Ohje"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

