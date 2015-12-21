package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'zh_CN'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_zh_CN extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "确定"},
			{ButtonId.ABORT.toString(), "放弃"},
			{ButtonId.CANCEL.toString(), "取消"},
			{ButtonId.YES.toString(), "是"},
			{ButtonId.NO.toString(), "否"},
			{ButtonId.CLOSE.toString(), "关闭"},
			{ButtonId.SAVE.toString(), "保存"},
			{ButtonId.RETRY.toString(), "重试"},
			{ButtonId.IGNORE.toString(), "忽略"},
			{ButtonId.HELP.toString(), "帮助"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}

