package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'xh'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_xh extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Kulungile"},
			{ButtonId.ABORT.toString(), "Abandner"},
			{ButtonId.CANCEL.toString(), "Rinoncî"},
			{ButtonId.YES.toString(), "Oyi"},
			{ButtonId.NO.toString(), "Neni"},
			{ButtonId.CLOSE.toString(), "Clôre"},
			{ButtonId.SAVE.toString(), "Schaper"},
			{ButtonId.RETRY.toString(), "Rissayî"},
			{ButtonId.IGNORE.toString(), "Passer houte"},
			{ButtonId.HELP.toString(), "Aidance"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

