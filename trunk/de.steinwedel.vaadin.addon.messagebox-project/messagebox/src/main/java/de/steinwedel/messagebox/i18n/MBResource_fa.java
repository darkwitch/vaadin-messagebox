package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'fa'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_fa extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "تأیید"},
			{ButtonId.ABORT.toString(), "ساقط کردن"},
			{ButtonId.CANCEL.toString(), "لغو"},
			{ButtonId.YES.toString(), "بله"},
			{ButtonId.NO.toString(), "نه"},
			{ButtonId.CLOSE.toString(), "بستن"},
			{ButtonId.SAVE.toString(), "ذخیره"},
			{ButtonId.RETRY.toString(), "تلاش دوباره"},
			{ButtonId.IGNORE.toString(), "چشم‌پوشی"},
			{ButtonId.HELP.toString(), "کمک"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

