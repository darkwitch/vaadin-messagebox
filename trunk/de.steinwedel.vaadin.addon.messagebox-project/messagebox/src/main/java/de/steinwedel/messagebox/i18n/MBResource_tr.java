package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'tr'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_tr extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Tamam"},
			{ButtonId.ABORT.toString(), "İptal"},
			{ButtonId.CANCEL.toString(), "İptal"},
			{ButtonId.YES.toString(), "Evet"},
			{ButtonId.NO.toString(), "Hayır"},
			{ButtonId.CLOSE.toString(), "Kapat"},
			{ButtonId.SAVE.toString(), "Kaydet"},
			{ButtonId.RETRY.toString(), "Yeniden Dene"},
			{ButtonId.IGNORE.toString(), "Yoksay"},
			{ButtonId.HELP.toString(), "Yardım"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

