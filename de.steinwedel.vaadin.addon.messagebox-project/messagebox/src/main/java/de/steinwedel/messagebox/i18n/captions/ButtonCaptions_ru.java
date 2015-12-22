package de.steinwedel.messagebox.i18n.captions;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonType;

/**
 * I18n for the button captions. This class contains the translations for language code 'ru'.
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptions_ru extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonType.OK.name(), "ОК"},
			{ButtonType.ABORT.name(), "Прервать"},
			{ButtonType.CANCEL.name(), "Отмена"},
			{ButtonType.YES.name(), "Да"},
			{ButtonType.NO.name(), "Нет"},
			{ButtonType.CLOSE.name(), "Закрыть"},
			{ButtonType.SAVE.name(), "Сохранить"},
			{ButtonType.RETRY.name(), "Повторить"},
			{ButtonType.IGNORE.name(), "Игнорировать"},
			{ButtonType.HELP.name(), "Справка"},
		};
	}

}

