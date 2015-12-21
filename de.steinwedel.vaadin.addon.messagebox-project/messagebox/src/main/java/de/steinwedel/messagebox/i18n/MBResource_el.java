package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'el'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_el extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Εντάξει"},
			{ButtonId.ABORT.toString(), "Εγκατάλειψη"},
			{ButtonId.CANCEL.toString(), "Ακύρωση"},
			{ButtonId.YES.toString(), "Ναι"},
			{ButtonId.NO.toString(), "Όχι"},
			{ButtonId.CLOSE.toString(), "Κλείσιμο"},
			{ButtonId.SAVE.toString(), "Αποθήκευση"},
			{ButtonId.RETRY.toString(), "Προσπάθεια ξανά"},
			{ButtonId.IGNORE.toString(), "Αγνόηση"},
			{ButtonId.HELP.toString(), "Βοήθεια"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

