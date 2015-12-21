package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'kk'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_kk extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "ОК"},
			{ButtonId.ABORT.toString(), "Доғару"},
			{ButtonId.CANCEL.toString(), "Қайту"},
			{ButtonId.YES.toString(), "Иә"},
			{ButtonId.NO.toString(), "Жоқ"},
			{ButtonId.CLOSE.toString(), "Жабу"},
			{ButtonId.SAVE.toString(), "Сақтау"},
			{ButtonId.RETRY.toString(), "Қайталау"},
			{ButtonId.IGNORE.toString(), "Елемеу"},
			{ButtonId.HELP.toString(), "Анықтама"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

