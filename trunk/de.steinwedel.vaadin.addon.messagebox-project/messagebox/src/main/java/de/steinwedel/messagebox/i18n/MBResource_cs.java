package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'cs'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_cs extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Přerušit"},
			{ButtonId.CANCEL.toString(), "Zrušit"},
			{ButtonId.YES.toString(), "Ano"},
			{ButtonId.NO.toString(), "Ne"},
			{ButtonId.CLOSE.toString(), "Zavřít"},
			{ButtonId.SAVE.toString(), "Uložit"},
			{ButtonId.RETRY.toString(), "Zkusit znovu"},
			{ButtonId.IGNORE.toString(), "Ignorovat"},
			{ButtonId.HELP.toString(), "Nápověda"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

