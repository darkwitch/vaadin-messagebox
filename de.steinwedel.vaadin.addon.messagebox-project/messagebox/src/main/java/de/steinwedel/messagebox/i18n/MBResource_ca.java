package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ca'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ca extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "D'acord"},
			{ButtonId.ABORT.toString(), "Interromp"},
			{ButtonId.CANCEL.toString(), "Cancel·la"},
			{ButtonId.YES.toString(), "Sí"},
			{ButtonId.NO.toString(), "No"},
			{ButtonId.CLOSE.toString(), "Tanca"},
			{ButtonId.SAVE.toString(), "Desa"},
			{ButtonId.RETRY.toString(), "Reintenta"},
			{ButtonId.IGNORE.toString(), "Ignora"},
			{ButtonId.HELP.toString(), "Ajuda"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

