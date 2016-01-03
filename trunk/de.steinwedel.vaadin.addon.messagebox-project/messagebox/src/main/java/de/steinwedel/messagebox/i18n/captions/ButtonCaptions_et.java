package de.steinwedel.messagebox.i18n.captions;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonType;

/**
 * I18n for the button captions. This class contains the translations for language code 'et'.
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptions_et extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonType.OK.name(), "OK"},
			{ButtonType.ABORT.name(), "Katkesta"},
			{ButtonType.CANCEL.name(), "Loobu"},
			{ButtonType.YES.name(), "Jah"},
			{ButtonType.NO.name(), "Ei"},
			{ButtonType.CLOSE.name(), "Sulge"},
			{ButtonType.SAVE.name(), "Salvesta"},
			{ButtonType.RETRY.name(), "Proovi uuesti"},
			{ButtonType.IGNORE.name(), "Eira"},
			{ButtonType.HELP.name(), "Abi"},
		};
	}

}

