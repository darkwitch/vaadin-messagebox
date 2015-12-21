package de.steinwedel.messagebox.i18n;

import java.util.ListResourceBundle;
import de.steinwedel.messagebox.ButtonId;

/**
 * I18n for the button captions. This class contains the translations for language code 'ko'.
 * 
 * @author Dieter Steinwedel
 */
public class MBResource_ko extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonId.OK.toString(), "확인"},
			{ButtonId.ABORT.toString(), "중단"},
			{ButtonId.CANCEL.toString(), "취소"},
			{ButtonId.YES.toString(), "예"},
			{ButtonId.NO.toString(), "아니오"},
			{ButtonId.CLOSE.toString(), "닫기"},
			{ButtonId.SAVE.toString(), "저장"},
			{ButtonId.RETRY.toString(), "다시 시도"},
			{ButtonId.IGNORE.toString(), "무시"},
			{ButtonId.HELP.toString(), "도움말"},
			{ButtonId.CUSTOM_1.toString(), "Custom 1"},
		        {ButtonId.CUSTOM_2.toString(), "Custom 2"},
		        {ButtonId.CUSTOM_3.toString(), "Custom 3"},
		        {ButtonId.CUSTOM_4.toString(), "Custom 4"},
		        {ButtonId.CUSTOM_5.toString(), "Custom 5"},
		};
	}

}
