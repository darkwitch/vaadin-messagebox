package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'be'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_be extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Добра"},
			{ButtonId.ABORT.toString(), "Перарваць"},
			{ButtonId.CANCEL.toString(), "Скасаваць"},
			{ButtonId.YES.toString(), "Так"},
			{ButtonId.NO.toString(), "Не"},
			{ButtonId.CLOSE.toString(), "أغلق"},
			{ButtonId.SAVE.toString(), "احفظ"},
			{ButtonId.RETRY.toString(), "أعِد المحاولة"},
			{ButtonId.IGNORE.toString(), "تجاهل"},
			{ButtonId.HELP.toString(), "مساعدة"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

