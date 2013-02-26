package de.steinwedel.messagebox;

import java.util.ArrayList;

import com.vaadin.server.Resource;
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


public class MessageBox implements ClickListener {
	
	private static final long serialVersionUID = 1L;
	
	// default configurations =================================================
	
	/**
	 * You can override the class <code>DefaultResources</code> to customize the default icons.
	 * The default captions for the buttons can be set to the map {@link DefaultResources#BUTTON_CAPTION}.
	 */
	public static DefaultResources DEFAULT_RESOURCES = new DefaultResources();

	/**
	 * Switches the default behavior the window between modal and none-modal.
	 * The default value is <code>true</code>.
	 */
	public static boolean DEFAULT_MODAL = true;
	
	/**
	 * Configures the default behavior, if the dialog is automatically closed or not after a dialog button is clicked.
	 * The default value is <code>true</code>.
	 */
	public boolean DEFAULT_AUTO_CLOSE = true;
	
	/**
	 * Configures the default button alignment.
	 * The default value is <code>Alignment.MIDDLE_RIGHT</code>.
	 */
	public Alignment DEFAULT_BUTTON_ALIGNMENT = Alignment.MIDDLE_RIGHT;
	
	/**
	 * You can implement transitions inside the {@see TransitionListener}. 
	 */
	public static TransitionListener TRANSITION_LISTENER;
	
	// dialog specific configurations =========================================
	
	protected Window window;
	protected VerticalLayout mainLayout;
	protected HorizontalLayout contentLayout;
	protected HorizontalLayout buttonLayout;
	
	protected Resource iconResource;
	protected String title;
	protected Component messageComponent;
	protected MessageBoxListener listener;
	protected ArrayList<Component> buttons;
	protected boolean autoClose;
	
	// constructors ===========================================================
	
	protected MessageBox(Resource iconResource, String title, Component messageComponent, MessageBoxListener listener, ButtonId... buttonIds) {
		this.iconResource = iconResource;
		this.title = title;
		this.messageComponent = messageComponent;
		this.listener = listener;
		this.autoClose = DEFAULT_AUTO_CLOSE;
		
		buttons = new ArrayList<Component>();
		for (ButtonId id : buttonIds) {
			buttons.add(DEFAULT_RESOURCES.getButton(id));
		}
	}
	
	// methods for customizing the dialog =====================================
	
	public Button getButton(ButtonId buttonId) {
		for (Component c : buttons) {
			if (c instanceof Button) {
				Button b = (Button) c;
				if (buttonId.equals(b.getData())) {
					return b;
				}
			}
		}
		return null;
	}
	
	public MessageBox setWidth(String width) {
		window.setWidth(width);
		if (-1f != window.getWidth()) {
			mainLayout.setWidth("100%");
		} else {
			mainLayout.setWidth(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	public MessageBox setWidth(float width, Unit unit) {
		window.setWidth(width, unit);
		if (-1f != window.getWidth()) {
			mainLayout.setWidth("100%");
		} else {
			mainLayout.setWidth(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	public MessageBox setHeight(String height) {
		window.setHeight(height);
		if (-1f != window.getHeight()) {
			mainLayout.setHeight("100%");
		} else {
			mainLayout.setHeight(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	public MessageBox setHeight(float height, Unit unit) {
		window.setHeight(height, unit);
		if (-1f != window.getHeight()) {
			mainLayout.setHeight("100%");
		} else {
			mainLayout.setHeight(-1f, Unit.PIXELS);
		}
		return this;
	}
	
	public MessageBox setModal(boolean modal) {
		window.setModal(modal);
		return this;
	}
	
	public MessageBox setAutoClose(boolean autoClose) {
		this.autoClose = autoClose;
		return this;
	}
		
	public MessageBox setButtonAlignment(Alignment alignment) {
		mainLayout.setComponentAlignment(buttonLayout, alignment);
		return this;
	}
	
	public MessageBox setButtonWidth(String width) {
		for (Component c : buttons) {
			if (c instanceof Button) {
				Button b = (Button) c;
				b.setWidth(width);
			}
		}
		return this;
	}
	
	public MessageBox setButtonWidth(float width, Unit unit) {
		for (Component c : buttons) {
			if (c instanceof Button) {
				Button b = (Button) c;
				b.setWidth(width, unit);
			}
		}
		return this;
	}
	
	public Window getWindow() {
		return window;
	}
	
	// methods for showing and closing the dialog =============================
	
	public static MessageBox showPlain(Icon icon, String title, String plainTextMessage, ButtonId... buttonIds) {
		return showPlain(icon, title, plainTextMessage, null, buttonIds);
	}
	
	public static MessageBox showPlain(Icon icon, String title, String plainTextMessage, MessageBoxListener listener, ButtonId... buttonIds) {
		return showHTML(icon, title, encodeToHtml(plainTextMessage), listener, buttonIds);
	}
	
	public static MessageBox showHTML(Icon icon, String title, String htmlMessage, ButtonId... buttonIds) {
		return showHTML(icon, title, htmlMessage, null, buttonIds);
	}

	public static MessageBox showHTML(Icon icon, String title, String htmlMessage, MessageBoxListener listener, ButtonId... buttonIds) {
		return showCustomized(icon, title, new Label(htmlMessage, ContentMode.HTML), listener, buttonIds);
	}
	
	public static MessageBox showCustomized(Icon icon, String title, Component messageComponent, MessageBoxListener listener, ButtonId... buttonIds) {
		return showCustomized(DEFAULT_RESOURCES.getIcon(icon), title, messageComponent, listener, buttonIds);
	}
	
	public static MessageBox showCustomized(Resource iconResource, String title, Component messageComponent, MessageBoxListener listener, ButtonId... buttonIds) {
		MessageBox result = new MessageBox(iconResource, title, messageComponent, listener, buttonIds);
		result.open();
		return result;
	}
	
	protected static String encodeToHtml(String plainText) {
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
	
	protected void open() {
		// Create window
		window = new Window(title);
		window.setClosable(false);
		window.setModal(DEFAULT_MODAL);
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
		
		// Add icon component
		if (iconResource != null) {
			Embedded embedded = new Embedded(null, iconResource);
			contentLayout.addComponent(embedded);
			contentLayout.setComponentAlignment(embedded, Alignment.MIDDLE_CENTER);
		}
		
		// Add message component
		messageComponent.setSizeFull();		
		contentLayout.addComponent(messageComponent);
		contentLayout.setExpandRatio(messageComponent, 1.0f);		
		contentLayout.setComponentAlignment(messageComponent, Alignment.MIDDLE_CENTER);
		
		// Create layout for the buttons 
		buttonLayout = new HorizontalLayout();
		buttonLayout.setImmediate(false);
		buttonLayout.setSizeUndefined();
		buttonLayout.setMargin(false);
		buttonLayout.setSpacing(true);
		mainLayout.addComponent(buttonLayout);
		mainLayout.setComponentAlignment(buttonLayout, Alignment.MIDDLE_RIGHT);
		
		// Add buttons
		for (Component c : buttons) {
			buttonLayout.addComponent(c);
			if (c instanceof Button) {
				Button b = (Button) c;
				b.addClickListener(this);
			}
		}
		
		// Add window to the UI
		if (TRANSITION_LISTENER == null || (TRANSITION_LISTENER != null && TRANSITION_LISTENER.show(this))) {
			UI.getCurrent().addWindow(window);
		}		
	}
	
	public void close() {
		if (TRANSITION_LISTENER == null || (TRANSITION_LISTENER != null && TRANSITION_LISTENER.close(this))) {
			UI.getCurrent().removeWindow(window);
		}
	}

	// ClickListener implementation ===========================================
	
	@Override
	public void buttonClick(ClickEvent event) {
		ButtonId buttonId = (ButtonId) event.getButton().getData();
		if (listener != null) {
			listener.buttonClicked(buttonId);
		}
		if (autoClose && !ButtonId.HELP.equals(buttonId)) {
			close();
		}
		
	}
	
}
