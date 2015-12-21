package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'eu'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_eu extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "Ados"},
			{ButtonId.ABORT.toString(), "Galarazi"},
			{ButtonId.CANCEL.toString(), "Utzi"},
			{ButtonId.YES.toString(), "Bai"},
			{ButtonId.NO.toString(), "Ez"},
			{ButtonId.CLOSE.toString(), "Itxi"},
			{ButtonId.SAVE.toString(), "Gorde"},
			{ButtonId.RETRY.toString(), "Saiatu berriz"},
			{ButtonId.IGNORE.toString(), "Ez ikusi egin"},
			{ButtonId.HELP.toString(), "Laguntza"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

