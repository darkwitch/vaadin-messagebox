package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'pt_BR'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_pt_BR extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "OK"},
			{ButtonId.ABORT.toString(), "Cancelar"},
			{ButtonId.CANCEL.toString(), "Cancelar"},
			{ButtonId.YES.toString(), "Sim"},
			{ButtonId.NO.toString(), "Não"},
			{ButtonId.CLOSE.toString(), "Fechar"},
			{ButtonId.SAVE.toString(), "Salvar"},
			{ButtonId.RETRY.toString(), "Tentar novamente"},
			{ButtonId.IGNORE.toString(), "Ignorar"},
			{ButtonId.HELP.toString(), "Ajuda"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

