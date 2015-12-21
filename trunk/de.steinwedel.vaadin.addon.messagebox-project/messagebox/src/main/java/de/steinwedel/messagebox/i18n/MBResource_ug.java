package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ug'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ug extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "تامام"},
			{ButtonId.ABORT.toString(), "توختات"},
			{ButtonId.CANCEL.toString(), "ئەمەلدىن قالدۇر"},
			{ButtonId.YES.toString(), "ھەئە"},
			{ButtonId.NO.toString(), "ياق"},
			{ButtonId.CLOSE.toString(), "ياپ"},
			{ButtonId.SAVE.toString(), "ساقلا"},
			{ButtonId.RETRY.toString(), "قايتا سىنا"},
			{ButtonId.IGNORE.toString(), "پەرۋا قىلما"},
			{ButtonId.HELP.toString(), "ياردەم"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

