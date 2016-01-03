package de.steinwedel.messagebox.i18n.captions;

import java.util.ListResourceBundle;

import de.steinwedel.messagebox.ButtonType;

/**
 * I18n for the button captions. This class contains the translations for language code 'ko'.
 * 
 * @author Dieter Steinwedel
 */
public class ButtonCaptions_ko extends ListResourceBundle {

	/**
	 * See {@link java.util.ListResourceBundle#getContents()}
	 */
	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{ButtonType.OK.name(), "확인"},
			{ButtonType.ABORT.name(), "중단"},
			{ButtonType.CANCEL.name(), "취소"},
			{ButtonType.YES.name(), "예"},
			{ButtonType.NO.name(), "아니오"},
			{ButtonType.CLOSE.name(), "닫기"},
			{ButtonType.SAVE.name(), "저장"},
			{ButtonType.RETRY.name(), "다시 시도"},
			{ButtonType.IGNORE.name(), "무시"},
			{ButtonType.HELP.name(), "도움말"},
		};
	}

}

