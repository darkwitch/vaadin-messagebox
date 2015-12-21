package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'et'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_et extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Katkesta"},
			{ButtonId.CANCEL.toString(), "Loobu"},
			{ButtonId.YES.toString(), "Jah"},
			{ButtonId.NO.toString(), "Ei"},
			{ButtonId.CLOSE.toString(), "Sulge"},
			{ButtonId.SAVE.toString(), "Salvesta"},
			{ButtonId.RETRY.toString(), "Proovi uuesti"},
			{ButtonId.IGNORE.toString(), "Eira"},
			{ButtonId.HELP.toString(), "Abi"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

