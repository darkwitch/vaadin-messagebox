package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. German translation.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_de extends ListResourceBundle {

	/*
	 * @see java.util.ListResourceBundle#getContents()
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
				{ButtonId.OK.toString(), "Ok"},
		        {ButtonId.ABORT.toString(), "Abbrechen"},
		        {ButtonId.CANCEL.toString(), "Abbrechen"},
		        {ButtonId.YES.toString(), "Ja"},
		        {ButtonId.NO.toString(), "Nein"},
		        {ButtonId.CLOSE.toString(), "Schlie�en"},
		        {ButtonId.SAVE.toString(), "Speichern"},
		        {ButtonId.RETRY.toString(), "Wiederholen"},
		        {ButtonId.IGNORE.toString(), "Ignorieren"},
		        {ButtonId.HELP.toString(), "Hilfe"},
		        {ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}
