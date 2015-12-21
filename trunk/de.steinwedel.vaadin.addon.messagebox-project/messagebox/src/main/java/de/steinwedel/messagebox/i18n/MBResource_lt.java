package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'lt'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_lt extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Gerai"},
			{ButtonId.ABORT.toString(), "Nutraukti"},
			{ButtonId.CANCEL.toString(), "Atsisakau"},
			{ButtonId.YES.toString(), "Taip"},
			{ButtonId.NO.toString(), "Ne"},
			{ButtonId.CLOSE.toString(), "Užverti"},
			{ButtonId.SAVE.toString(), "Įrašyti"},
			{ButtonId.RETRY.toString(), "Bandyti vėl"},
			{ButtonId.IGNORE.toString(), "Ignoruoti"},
			{ButtonId.HELP.toString(), "Pagalba"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

