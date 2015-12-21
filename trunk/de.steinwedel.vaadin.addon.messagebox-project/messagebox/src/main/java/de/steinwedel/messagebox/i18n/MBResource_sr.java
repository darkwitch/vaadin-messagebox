package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'sr'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_sr extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "У реду"},
			{ButtonId.ABORT.toString(), "Обустави"},
			{ButtonId.CANCEL.toString(), "Одустани"},
			{ButtonId.YES.toString(), "Да"},
			{ButtonId.NO.toString(), "Не"},
			{ButtonId.CLOSE.toString(), "Затвори"},
			{ButtonId.SAVE.toString(), "сачувај"},
			{ButtonId.RETRY.toString(), "Покушај поново"},
			{ButtonId.IGNORE.toString(), "Игнориши"},
			{ButtonId.HELP.toString(), "Помоћ"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

