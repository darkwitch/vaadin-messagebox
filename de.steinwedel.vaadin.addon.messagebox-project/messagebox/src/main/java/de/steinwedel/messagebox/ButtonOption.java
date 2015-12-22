package de.steinwedel.messagebox;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public abstract class ButtonOption {

	public abstract void apply(MessageBox messageBox, Button button);
	
	public static ButtonOption focus() {
		return new ButtonOption() {
			
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.focus();
			}
			
		};
	}
	
	public static ButtonOption style(final String styleName) {
		return new ButtonOption() {
			
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setStyleName(styleName);
			}
			
		};
	}
	
	public static ButtonOption width(final String width) {
		return new ButtonOption() {
			
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setWidth(width);
			}
			
		};
	}
	
	public static ButtonOption caption(final String caption) {
		return new ButtonOption() {
			
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setCaption(caption);
			}
			
		};
	}
	
	public static class CloseOnClick extends ButtonOption {
		
		private boolean closeOnClick;
		
		public CloseOnClick(boolean closeOnClick) {
			this.closeOnClick = closeOnClick;
		}
		
		@Override
		public void apply(final MessageBox messageBox, Button button) {
			if (closeOnClick) {
				button.addClickListener(new ClickListener() {
					
					private static final long serialVersionUID = 1L;

					@Override
					public void buttonClick(ClickEvent event) {
						messageBox.close();
					}
					
				});

			}
		}
		
	}
	
	public static ButtonOption closeOnClick(final boolean closeOnClick) {
		return new CloseOnClick(closeOnClick);
	}

	public static ButtonOption icon(final Resource icon) {
		return new ButtonOption() {
			
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setIcon(icon);
			}
			
		};
	}
	
}
