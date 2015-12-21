package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'pa'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_pa extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "ਠੀਕ ਹੈ"},
			{ButtonId.ABORT.toString(), "ਛੱਡੋ"},
			{ButtonId.CANCEL.toString(), "ਰੱਦ ਕਰੋ"},
			{ButtonId.YES.toString(), "ਹਾਂ"},
			{ButtonId.NO.toString(), "ਨਹੀਂ"},
			{ButtonId.CLOSE.toString(), "ਬੰਦ ਕਰੋ"},
			{ButtonId.SAVE.toString(), "ਸੰਭਾਲੋ"},
			{ButtonId.RETRY.toString(), "ਮੁੜ-ਕੋਸ਼ਿਸ਼"},
			{ButtonId.IGNORE.toString(), "ਅਣਡਿੱਠਾ"},
			{ButtonId.HELP.toString(), "ਮੱਦਦ"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

