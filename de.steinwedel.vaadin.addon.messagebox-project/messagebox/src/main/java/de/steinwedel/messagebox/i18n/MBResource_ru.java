package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. Here is the Russian translation implemented.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ru extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ButtonId.OK.toString(), "Ok"},
				{ButtonId.ABORT.toString(), "Прервать"},
				{ButtonId.CANCEL.toString(), "Отмена"},
				{ButtonId.YES.toString(), "Да"},
				{ButtonId.NO.toString(), "Нет"},
				{ButtonId.CLOSE.toString(), "Закрыть"},
				{ButtonId.SAVE.toString(), "Сохранить"},
				{ButtonId.RETRY.toString(), "Повторить"},
				{ButtonId.IGNORE.toString(), "Игнорировать"},
				{ButtonId.HELP.toString(), "Справка"},
		        {ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}
