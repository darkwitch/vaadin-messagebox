package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ka'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ka extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "დიახ"},
			{ButtonId.ABORT.toString(), "Hætta við"},
			{ButtonId.CANCEL.toString(), "Hætta við"},
			{ButtonId.YES.toString(), "Já"},
			{ButtonId.NO.toString(), "Nei"},
			{ButtonId.CLOSE.toString(), "Bezárás"},
			{ButtonId.SAVE.toString(), "Mentés"},
			{ButtonId.RETRY.toString(), "Újra"},
			{ButtonId.IGNORE.toString(), "Figyelmen kívül hagyás"},
			{ButtonId.HELP.toString(), "Súgó"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

