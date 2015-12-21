package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'th'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_th extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "ตกลง"},
			{ButtonId.ABORT.toString(), "ยุติ"},
			{ButtonId.CANCEL.toString(), "ยกเลิก"},
			{ButtonId.YES.toString(), "ใช่"},
			{ButtonId.NO.toString(), "ไม่"},
			{ButtonId.CLOSE.toString(), "ปิด"},
			{ButtonId.SAVE.toString(), "บันทึก"},
			{ButtonId.RETRY.toString(), "ลองใหม่"},
			{ButtonId.IGNORE.toString(), "ไม่สนใจ"},
			{ButtonId.HELP.toString(), "ช่วยเหลือ"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

