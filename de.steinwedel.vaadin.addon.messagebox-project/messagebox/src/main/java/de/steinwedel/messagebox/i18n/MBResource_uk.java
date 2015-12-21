package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'uk'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_uk extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Гаразд"},
			{ButtonId.ABORT.toString(), "Перервати"},
			{ButtonId.CANCEL.toString(), "Скасувати"},
			{ButtonId.YES.toString(), "Так"},
			{ButtonId.NO.toString(), "Ні"},
			{ButtonId.CLOSE.toString(), "Закрити"},
			{ButtonId.SAVE.toString(), "Зберегти"},
			{ButtonId.RETRY.toString(), "Спробувати ще раз"},
			{ButtonId.IGNORE.toString(), "Ігнорувати"},
			{ButtonId.HELP.toString(), "Довідка"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

