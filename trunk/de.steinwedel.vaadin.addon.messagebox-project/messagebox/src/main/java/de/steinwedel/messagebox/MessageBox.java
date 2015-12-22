package de.steinwedel.messagebox;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;

import com.vaadin.client.ui.Icon;
import com.vaadin.server.VaadinService;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.steinwedel.messagebox.i18n.ButtonCaptionFactory;
import de.steinwedel.messagebox.icons.ButtonIconFactory;
import de.steinwedel.messagebox.icons.ClassicButtonIconFactory;
import de.steinwedel.messagebox.icons.ClassicDialogIconFactory;
import de.steinwedel.messagebox.icons.DialogIconFactory;

/**
 * <p><b>DESCRIPTION AND FEATURES</b></p>
 * <p>MessageBox is a flexible utility class for generating different styles of messageboxes. 
 * The messagebox is typically a modal dialog, with an icon on the left side, 
 * a message on the right of the icon and some buttons on the bottom of the dialog.
 * </p> 
 * <p>E.g. you can define/customize</p>
 * <ul>
 * <li>the window caption</li>
 * <li>different types of icons (see {@link Icon})</li>
 * <li>a message as plain string or HTML or with a custom component</li>
 * <li>which and how many buttons are placed on the dialog</li>
 * <li>the icon and appearance of the buttons</li>
 * <li>the buttons alignment (left, centered, right)</li>
 * <li>one simple event listener (see {@link MessageBoxListener}) for all buttons</li>
 * </ul>
 * <p>Now, real I18n is supported via {@code java.util.ResourceBundle}. Even a new feature is, that 
 * the dialog size is determined automatically from the message itself - but it can be overridden explicitly, if required.
 * You need less code to show a messagebox in compare to version 1.x of this add-on. Even the naming, packaging and javadoc has been improved.  
 * </p>
 * <p><b>USAGE</b></p>
 * <p>
 * <code>MessageBox.showPlain(Icon.INFO, "Example 1", "Hello World!", ButtonId.OK);</code>
 * This example shows a simple message dialog, with "Example 1" as dialog 
 * caption, an info icon, "Hello World!" as message and an "Ok" labeled button. The 
 * dialog is displayed modally. To receive an event of the pressed button, add an event listener (see 
 * {@link MessageBoxListener}). I have added a demo class (Demo.java) with many examples, to show most of the possible use cases.
 * There are many more ways to display and customize a messagebox.</p>
 * <br>
 * <p><b>LICENSE</b></p>
 * <p>The licenses are suitable for commercial usage.</p>
 * 
 * <p>Code license: Apache License 2.0</p>
 * 
 * <p>Dialog icons:</p>
 * <ul><li>Author: Dieter Steinwedel</li>
 * <li>License: Creative Commons Attribution 2.5 License</li></ul>
 * 
 * <p>Button icons:</p>
 * <ul><li>Author: Mark James</li>
 * <li>URL: <a href="http://www.famfamfam.com/lab/icons/silk/">http://www.famfamfam.com/lab/icons/silk/</a></li>
 * <li>License: Creative Commons Attribution 2.5 License</li></ul>
 * 
 * @author Dieter Steinwedel
 */
public class MessageBox implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// default configurations =================================================

	/**
	 * You can implement transitions inside the {@link TransitionListener}. 
	 */
	private static TransitionListener DIALOG_DEFAULT_TRANSITION_LISTENER;
	
	private static Locale DIALOG_DEFAULT_LOCALE = Locale.ENGLISH;
	
	/**
	 * You can override the class {@link DialogIconFactory} to customize the default dialog icons. 
	 */
	private static DialogIconFactory DIALOG_DEFAULT_ICON_FACTORY = new ClassicDialogIconFactory();
	
	/**
	 * Defines the default width of the dialog icon. It is recommended to set it unequal '-1px', 
	 * because otherwise there is re-rendering of dialog recognizable when the dialog is displayed.
	 * The cause is, that the icon is lazy loaded. 
	 */
	private static String DIALOG_DEFAULT_ICON_WIDTH = "48px";
	
	/**
	 * Defines the default height of the dialog icon. It is recommended to set it unequal '-1px', 
	 * because otherwise there is re-rendering of dialog recognizable when the dialog is displayed.
	 * The cause is, that the icon is lazy loaded. 
	 */
	private static String DIALOG_DEFAULT_ICON_HEIGHT = "48px";

	/**
	 * Configures the default button alignment.
	 * The default value is <code>Alignment.MIDDLE_RIGHT</code>.
	 */
	private static Alignment BUTTON_DEFAULT_ALIGNMENT = Alignment.MIDDLE_RIGHT;
	
	private static ButtonCaptionFactory BUTTON_DEFAULT_CAPTION_FACTORY = new ButtonCaptionFactory();
	
	/**
	 * You can override the class {@link DialogIconFactory} to customize the default dialog icons. 
	 */
	private static ButtonIconFactory BUTTON_DEFAULT_ICON_FACTORY = new ClassicButtonIconFactory();
	
	//TODO disable icons
	
	// dialog specific configurations =========================================
	
	/**
	 * Keeps the reference to the window of the messagebox.
	 */
	protected Window window;
	
	/**
	 * The main layout for the messagebox.
	 */
	protected VerticalLayout mainLayout;
	
	/**
	 * The content layout for the messagebox. It is the first item in the {@link #mainLayout}.
	 */
	protected HorizontalLayout contentLayout;
	
	/**
	 * The button layout for the messagebox. It is the second item in the {@link #mainLayout}.
	 */
	protected HorizontalLayout buttonLayout;
	
	/**
	 * The dialog icon for the message box. It is typically the first item in the {@link #contentLayout}.
	 */
	protected Embedded icon;
	
	/**
	 * The component, that displays message. By default it is a label. Typically, this component is the second item in the {@link #contentLayout}.
	 */
	protected Component messageComponent;
	
	protected String buttonWidth;
	
	protected boolean buttonAdded;
	
	protected Object data;
	
	// static methods =========================================================
	
	public static void setDialogDefaultTransitionListener(TransitionListener listener) {
		DIALOG_DEFAULT_TRANSITION_LISTENER = listener;
	}
	
	
	public static void setDialogDefaultLanguage(Locale locale) {
		if (locale != null) {
			DIALOG_DEFAULT_LOCALE = locale;
		}
	}
	
	public static void setSessionLanguage(Locale locale) {
		VaadinService.getCurrentRequest().getWrappedSession().setAttribute(ButtonCaptionFactory.LANGUAGE_SESSION_KEY, locale);
	}
	
	/**
	 * @param dialogIconFactory
	 */
	public static void setDialogDefaultIconFactory(DialogIconFactory dialogIconFactory) {
		if (dialogIconFactory != null) {
			DIALOG_DEFAULT_ICON_FACTORY = dialogIconFactory;
		}
	}
	
	/**
	 * @param defaultDialogIconFactory
	 */
	public static void setDialogDefaultIconWidth(String width) {
		if (width != null) {
			DIALOG_DEFAULT_ICON_WIDTH = width;
		}
	}
	
	/**
	 * @param defaultDialogIconFactory
	 */
	public static void setDialogDefaultIconHeight(String height) {
		if (height != null) {
			DIALOG_DEFAULT_ICON_HEIGHT = height;
		}
	}
	
	/**
	 * @param defaultDialogIconFactory
	 */
	public static void setButtonDefaultAlignment(Alignment alignment) {
		if (alignment != null) {
			BUTTON_DEFAULT_ALIGNMENT = alignment;
		}
	}
	
	public static void setButtonDefaultIconFactory(ButtonIconFactory factory) {
		if (factory != null) {
			BUTTON_DEFAULT_ICON_FACTORY = factory;
		}
	}
	
	public static void setButtonDefaultCaptionFactory(ButtonCaptionFactory factory) {
		if (factory != null) {
			BUTTON_DEFAULT_CAPTION_FACTORY = factory;
		}
	}
	
	
	// constructors ===========================================================
	
	/**
	 * The constructor to initialize the dialog.
	 */
	protected MessageBox() {
		// Create window
		window = new Window();
		window.setClosable(false);
		window.setModal(true);
		window.setResizable(false);
		window.setSizeUndefined();
		
		// Create the top-level layout of the window
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setSizeUndefined();
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);
		window.setContent(mainLayout);
		
		// Layout for the dialog body (icon & message)
		contentLayout = new HorizontalLayout();
		mainLayout.addComponent(contentLayout);
		mainLayout.setExpandRatio(contentLayout, 1.0f);
		contentLayout.setSizeFull();
		contentLayout.setMargin(false);
		contentLayout.setSpacing(true);
		
		// Layout for the buttons 
		buttonLayout = new HorizontalLayout();
		buttonLayout.setImmediate(false);
		buttonLayout.setSizeUndefined();
		buttonLayout.setMargin(false);
		buttonLayout.setSpacing(true);
		mainLayout.addComponent(buttonLayout);
		mainLayout.setComponentAlignment(buttonLayout, BUTTON_DEFAULT_ALIGNMENT);	
		
		buttonAdded = false;
	}
	
	// methods for customizing the dialog =====================================
	
	/**
	 * Switches, if the dialog is shown modal or not.
	 * @param modal If set to <code>true</code>, the dialog is shown modal.
	 * @return The {@link MessageBox} instance itself
	 */
	public MessageBox asModal(boolean modal) {
		window.setModal(modal);
		return this;
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @return The MessageBox instance itself
	 */
	public MessageBox asQuestion() {
		return withIcon(DIALOG_DEFAULT_ICON_FACTORY.getQuestionIcon());
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @return The MessageBox instance itself
	 */
	public MessageBox asInfo() {
		return withIcon(DIALOG_DEFAULT_ICON_FACTORY.getInfoIcon());
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @return The MessageBox instance itself
	 */
	public MessageBox asWarning() {
		return withIcon(DIALOG_DEFAULT_ICON_FACTORY.getWarningIcon());
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @return The MessageBox instance itself
	 */
	public MessageBox asError() {
		return withIcon(DIALOG_DEFAULT_ICON_FACTORY.getErrorIcon());
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @return The MessageBox instance itself
	 */
	public MessageBox withIcon(Embedded icon) {
		return withIcon(icon, DIALOG_DEFAULT_ICON_WIDTH, DIALOG_DEFAULT_ICON_HEIGHT);
	}
	
	/**
	 * Sets an icon to the message dialog.
	 * @param icon An embedded resource
	 * @param width The width i.e. "48px"
	 * @param height The height i.e. "48px"
	 * @return The MessageBox instance itself
	 */
	public MessageBox withIcon(Embedded icon, String width, String height) {
		if (this.icon != null) {
			contentLayout.removeComponent(this.icon);
		}
		
		this.icon = icon;		
		
		if (icon != null) {
			contentLayout.addComponent(icon, 0);
			contentLayout.setComponentAlignment(icon, Alignment.MIDDLE_CENTER);
			icon.setWidth(width); 
			icon.setHeight(height);
		}
		return this;
	}
	
	/**
	 * Sets the caption of the message dialog.
	 * @param caption The caption of the message dialog
	 * @return The MessageBox instance itself
	 */
	public MessageBox withCaption(String caption) {
		window.setCaption(caption);
		return this;
	}
	
	/**
	 * Sets a component as content to the message dialog.
	 * @param messageComponent The component as content
	 * @return The MessageBox instance itself
	 */
	public MessageBox withMessage(Component messageComponent) {
		if (this.messageComponent != null) {
			contentLayout.removeComponent(this.messageComponent);
		}
		
		this.messageComponent = messageComponent;
		
		if (messageComponent != null) {
			messageComponent.setSizeFull();
			contentLayout.addComponent(messageComponent, contentLayout.getComponentCount());
			contentLayout.setExpandRatio(messageComponent, 1.0f);		
			contentLayout.setComponentAlignment(messageComponent, Alignment.MIDDLE_CENTER);
		}
		return this;
	}
	
	/**
	 * Sets HTML as content to the message dialog.
	 * @param htmlMessage HTML as content
	 * @return The MessageBox instance itself
	 */
	public MessageBox withHtmlMessage(String htmlMessage) {
		return withMessage(new Label(htmlMessage, ContentMode.HTML));
	}
	
	/**
	 * Sets plain text as content to the message dialog.
	 * @param htmlContent HTML as content
	 * @return The MessageBox instance itself
	 */
	public MessageBox withMessage(String plainTextMessage) {
		return withHtmlMessage(encodeToHtml(plainTextMessage));
	}
	
	/**
	 * Forces a width for the message dialog.
	 * @param width The forced width
	 * @return The {@link MessageBox} instance itself.
	 */
	public MessageBox withWidth(String width) {
		window.setWidth(width);
		if (-1f != window.getWidth()) {
			mainLayout.setWidth("100%");
		} else {
			mainLayout.setWidth(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	/**
	 * Forces a height for the message dialog.
	 * @param height The forced height
	 * @return The {@link MessageBox} instance itself.
	 */
	public MessageBox withHeight(String height) {
		window.setHeight(height);
		if (-1f != window.getHeight()) {
			mainLayout.setHeight("100%");
		} else {
			mainLayout.setHeight(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	/**
	 * Forces a position for the message dialog.
	 * @param x The x position
	 * @param y The y position
	 * @return The {@link MessageBox} instance itself.
	 */
	public MessageBox withDialogPosition(int x, int y) {
		window.setPosition(x, y);
		return this;
	}
	
	/**
	 * Forces a x position for the message dialog.
	 * @param x The x position
	 * @return The {@link MessageBox} instance itself
	 */
	public MessageBox withDialogPositionX(int x) {
		window.setPositionX(x);
		return this;
	}
	
	/**
	 * Forces a y position for the message dialog.
	 * @param y The y position
	 * @return The {@link MessageBox} instance itself
	 */
	public MessageBox withDialogPositionY(int y) {
		window.setPositionY(y);
		return this;
	}
	
	/**
	 * Customizes the button alignment. 
	 * @param alignment The new button alignment
	 * @return The {@link MessageBox} instance itself.
	 */
	public MessageBox withButtonAlignment(Alignment alignment) {
		if (alignment != null) {
			mainLayout.setComponentAlignment(buttonLayout, alignment);
		}
		return this;
	}
	
	public MessageBox withButtonSpacer() {
		buttonLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		return this;
	}
	
	public MessageBox withSpacer() {
		return withButtonSpacer();
	}

	public MessageBox withButton(Button button, ButtonOption... options) {
		if (button != null) {
			buttonLayout.addComponent(button);
			
			buttonAdded = true;
			button.setImmediate(true);
			
			if (button.getData() != null && button.getData() instanceof Runnable) {
				button.addClickListener(new ClickListener() {
					
					private static final long serialVersionUID = 1L;

					@Override
					public void buttonClick(ClickEvent event) {
						Runnable runnable = (Runnable) event.getButton().getData();
						runnable.run();
					}
					
				});
			}
			
			boolean autoCloseNotFound = true;
			for (ButtonOption option : options) {
				option.apply(this, button);
				if (option instanceof ButtonOption.CloseOnClick) {
					autoCloseNotFound = false;
				}
			}
			if (autoCloseNotFound) {
				new ButtonOption.CloseOnClick(true).apply(this, button);
			}
		}
		return this;
	}
	
	public MessageBox withButton(ButtonType buttonType, Runnable runOnClick, ButtonOption... options) {
		Button button = new Button(BUTTON_DEFAULT_CAPTION_FACTORY.translate(buttonType, DIALOG_DEFAULT_LOCALE));
		button.setData(runOnClick);
		button.setIcon(BUTTON_DEFAULT_ICON_FACTORY.getIcon(buttonType));
		return withButton(button, options);
	}
	
	public MessageBox withOkButton(ButtonOption... options) {
		return withOkButton(null, options);
	}
	
	public MessageBox withOkButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.OK, runOnClick, options);
	}
	
	public MessageBox withAbortButton(ButtonOption... options) {
		return withAbortButton(null, options);
	}
	
	public MessageBox withAbortButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.ABORT, runOnClick, options);
	}
	
	public MessageBox withCancelButton(ButtonOption... options) {
		return withCancelButton(null, options);
	}
	
	public MessageBox withCancelButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.CANCEL, runOnClick, options);
	}
	
	public MessageBox withCloseButton(ButtonOption... options) {
		return withCloseButton(null, options);
	}
	
	public MessageBox withCloseButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.CLOSE, runOnClick, options);
	}
	
	public MessageBox withHelpButton(ButtonOption... options) {
		return withHelpButton(null, options);
	}
	
	public MessageBox withHelpButton(Runnable runOnClick, ButtonOption... options) {
		ButtonOption[] finalOptions = options;
		boolean addAutoCloseOption = true;
		for (ButtonOption option : options) {
			if (option instanceof ButtonOption.CloseOnClick) {
				addAutoCloseOption = false;
				break;
			}
		}
		if (addAutoCloseOption) {
			finalOptions = Arrays.copyOf(options, options.length + 1);
			finalOptions[options.length] = ButtonOption.closeOnClick(false);
		}
		return withButton(ButtonType.HELP, runOnClick, finalOptions);
	}
	
	public MessageBox withIgnoreButton(ButtonOption... options) {
		return withIgnoreButton(null, options);
	}
	
	public MessageBox withIgnoreButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.IGNORE, runOnClick, options);
	}
	
	public MessageBox withNoButton(ButtonOption... options) {
		return withNoButton(null, options);
	}
	
	public MessageBox withNoButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.NO, runOnClick, options);
	}
	
	public MessageBox withRetryButton(ButtonOption... options) {
		return withRetryButton(null, options);
	}
	
	public MessageBox withRetryButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.RETRY, runOnClick, options);
	}
	
	public MessageBox withSaveButton(ButtonOption... options) {
		return withSaveButton(null, options);
	}
	
	public MessageBox withSaveButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.SAVE, runOnClick, options);
	}
	
	public MessageBox withYesButton(ButtonOption... options) {
		return withYesButton(null, options);
	}
	
	public MessageBox withYesButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(ButtonType.YES, runOnClick, options);
	}
	
	public MessageBox withCustomButton(ButtonOption... options) {
		return withCustomButton(null, options);
	}
	
	public MessageBox withCustomButton(Runnable runOnClick, ButtonOption... options) {
		return withButton(null, runOnClick, options);
	}
	
	/**
	 * Sets the button width of all buttons for a symmetric appearance.
	 * @param width The button width.
	 * @return The {@link MessageBox} instance itself.
	 */
	public MessageBox withWidthForAllButtons(String width) {
		buttonWidth = width;
		return this;
	}
	
	public MessageBox withData(Object data) {
		setData(data);
		return this;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	/**
	 * Returns the <code>Window</code> of the dialog.
	 * @return The <code>Window</code> of the dialog.
	 */
	public Window getWindow() {
		return window;
	}
	
	/**
	 * Translates plain text to HTML formatted text with corresponding escape sequences.
	 * @param plainText		The plain text to translates.
	 * @return The HTML formatted text.
	 */
	protected String encodeToHtml(String plainText) {
	    StringBuilder builder = new StringBuilder();
	    boolean previousWasASpace = false;
	    for( char c : plainText.toCharArray() ) {
	        if( c == ' ' ) {
	            if( previousWasASpace ) {
	                builder.append("&nbsp;");
	                previousWasASpace = false;
	                continue;
	            }
	            previousWasASpace = true;
	        } else {
	            previousWasASpace = false;
	        }
	        switch(c) {
	            case '<': builder.append("&lt;"); break;
	            case '>': builder.append("&gt;"); break;
	            case '&': builder.append("&amp;"); break;
	            case '"': builder.append("&quot;"); break;
	            case '\n': builder.append("<br>"); break;
	            case '\t': builder.append("&nbsp; &nbsp; &nbsp;"); break;  
	            default:
	                if( c < 128 ) {
	                    builder.append(c);
	                } else {
	                    builder.append("&#").append((int)c).append(";");
	                }    
	        }
	    }
	    return builder.toString();
	}
		
	// methods for showing and closing the dialog =============================
	
	/**
	 * Creates and opens the window for the MessageBox.
	 * @return The message dialog instance  
	 */
	public static MessageBox create() {
		return new MessageBox();
	}
	
	public void open() {
		// Ensure, that the dialog has at least one button
		if (!buttonAdded) {
			withCloseButton();
		}
		
		// Apply some layouting options to the buttons
		for (int i = 0; i < buttonLayout.getComponentCount(); i++) {
			Component c = buttonLayout.getComponent(i);
			if (buttonWidth != null && c instanceof Button) {
				Button b = (Button) c;
				b.setWidth(buttonWidth);
			}
			buttonLayout.setComponentAlignment(c, Alignment.MIDDLE_CENTER);
		}
		
		// Add window to the UI
		if (DIALOG_DEFAULT_TRANSITION_LISTENER == null || (DIALOG_DEFAULT_TRANSITION_LISTENER != null && DIALOG_DEFAULT_TRANSITION_LISTENER.show(this))) {
			UI.getCurrent().addWindow(getWindow());
		}
	}
	
	/**
	 * Closes the window if open.
	 */
	public void close() {
		if (DIALOG_DEFAULT_TRANSITION_LISTENER == null || (DIALOG_DEFAULT_TRANSITION_LISTENER != null && DIALOG_DEFAULT_TRANSITION_LISTENER.close(this))) {
			UI.getCurrent().removeWindow(window);
		}
	}
	
}
