package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ga'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ga extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Tobscoir"},
			{ButtonId.CANCEL.toString(), "Cealaigh"},
			{ButtonId.YES.toString(), "Tá"},
			{ButtonId.NO.toString(), "Níl"},
			{ButtonId.CLOSE.toString(), "Dún"},
			{ButtonId.SAVE.toString(), "Sábháil"},
			{ButtonId.RETRY.toString(), "Atriail"},
			{ButtonId.IGNORE.toString(), "Déan neamhaird de"},
			{ButtonId.HELP.toString(), "Cabhair"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

