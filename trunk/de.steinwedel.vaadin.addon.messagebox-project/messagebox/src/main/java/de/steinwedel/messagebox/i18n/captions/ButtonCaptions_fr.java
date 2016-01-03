package de.steinwedel.messagebox.i18n.captions;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonType;

/**
 * I18n for the button captions. This class contains the translations for language code 'fr'.
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptions_fr extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonType.OK.name(), "Ok"},
			{ButtonType.ABORT.name(), "Interrompre"},
			{ButtonType.CANCEL.name(), "Annuler"},
			{ButtonType.YES.name(), "Oui"},
			{ButtonType.NO.name(), "Non"},
			{ButtonType.CLOSE.name(), "Fermer"},
			{ButtonType.SAVE.name(), "Enregistrer"},
			{ButtonType.RETRY.name(), "Réessayer"},
			{ButtonType.IGNORE.name(), "Ignorer"},
			{ButtonType.HELP.name(), "Aide"},
		};
	}

}

