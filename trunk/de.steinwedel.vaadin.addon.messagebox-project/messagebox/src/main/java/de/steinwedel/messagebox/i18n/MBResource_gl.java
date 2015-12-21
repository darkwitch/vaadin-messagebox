package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'gl'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_gl extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Aceptar"},
			{ButtonId.ABORT.toString(), "Interromper"},
			{ButtonId.CANCEL.toString(), "Cancelar"},
			{ButtonId.YES.toString(), "Si"},
			{ButtonId.NO.toString(), "Non"},
			{ButtonId.CLOSE.toString(), "Pechar"},
			{ButtonId.SAVE.toString(), "Gardar"},
			{ButtonId.RETRY.toString(), "Tentar de novo"},
			{ButtonId.IGNORE.toString(), "Ignorar"},
			{ButtonId.HELP.toString(), "Axuda"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

