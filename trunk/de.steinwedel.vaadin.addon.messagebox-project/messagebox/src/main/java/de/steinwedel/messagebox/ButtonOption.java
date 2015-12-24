package de.steinwedel.messagebox;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * With the ButtonOption can the buttons configured of a {@link MessageBox}.
 * 
 * @author Dieter Steinwedel
 */
public abstract class ButtonOption {

	/**
	 * Is used internally.
	 * 
	 * @param messageBox
	 * @param button
	 */
	public abstract void apply(MessageBox messageBox, Button button);
	
	/**
	 * Focuses the corresponding Button.
	 * 
	 * @return The ButtonOption
	 */
	public static ButtonOption focus() {
		return new ButtonOption() {
			
			/**
			 * See {@link ButtonOption#apply(MessageBox, Button)}
			 */
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.focus();
			}
			
		};
	}
	
	/**
	 * Applies a style to the corresponding button.
	 * 
	 * @param styleName
	 * @return The ButtonOption
	 */
	public static ButtonOption style(final String styleName) {
		return new ButtonOption() {
			
			/**
			 * See {@link ButtonOption#apply(MessageBox, Button)}
			 */
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setStyleName(styleName);
			}
			
		};
	}
	
	/**
	 * Changes the width of the corresponding button.
	 * 
	 * @param width
	 * @return The ButtonOption
	 */
	public static ButtonOption width(final String width) {
		return new ButtonOption() {
			
			/**
			 * See {@link ButtonOption#apply(MessageBox, Button)}
			 */
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setWidth(width);
			}
			
		};
	}
	
	/**
	 * Changes the caption of the corresponding button.
	 * 
	 * @param caption
	 * @return The ButtonOption
	 */
	public static ButtonOption caption(final String caption) {
		return new ButtonOption() {
			
			/**
			 * See {@link ButtonOption#apply(MessageBox, Button)}
			 */
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
		
		/**
		 * See {@link ButtonOption#apply(MessageBox, Button)}
		 */
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
	
	/**
	 * Changes the behavior of the corresponding button. If true, a click on the button closes the MessageBox.
	 * 
	 * @param width
	 * @return The ButtonOption
	 */
	public static ButtonOption closeOnClick(final boolean closeOnClick) {
		return new CloseOnClick(closeOnClick);
	}

	/**
	 * Sets the icon of the corresponding button.
	 * 
	 * @param width
	 * @return The ButtonOption
	 */
	public static ButtonOption icon(final Resource icon) {
		return new ButtonOption() {
			
			/**
			 * See {@link ButtonOption#apply(MessageBox, Button)}
			 */
			@Override
			public void apply(MessageBox messageBox, Button button) {
				button.setIcon(icon);
			}
			
		};
	}
	
}
