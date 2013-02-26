package de.steinwedel;

import java.util.Locale;

import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.MessageBoxListener;

/**
 * Demo Application for messagesboxes.
 * URL: http://localhost:8080/MessageBox/?restartApplication
 */
public class Demo extends UI {

	private static final long serialVersionUID = 1L;

	@Override
    public void init(VaadinRequest request) {
		getPage().setTitle("MessageBox Demo Application");
        GridLayout layout = new GridLayout(3,20);
        setContent(layout);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        layout.addComponent(new Label("<b>No</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Demo</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Description</b>", ContentMode.HTML));
        
        // Force locale "English"
        MessageBox.RESOURCE_FACTORY.setResourceLocale(Locale.ENGLISH);
        // You can use MessageBox.RESOURCES_FACTORY.setResourceBundle(basename); to localize to your language

        // Creates an info dialog
        layout.addComponent(new Label("1"));
        Button info = new Button("Info Dialog");
        info.setWidth("100%");
        layout.addComponent(info);
        info.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox.showPlain(Icon.INFO, "Example 1", "Hello World!", ButtonId.OK);
			}
			
		});
        layout.addComponent(new Label("Shows a messagebox with an info icon."));
        
        // Creates a question dialog
        layout.addComponent(new Label("2"));
        Button question = new Button("Question Dialog");
        question.setWidth("100%");
        layout.addComponent(question);
        question.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.QUESTION, "Example 2", "Do you really want to continue?", ButtonId.YES, ButtonId.NO);
			}
			
		});
        layout.addComponent(new Label("Shows a messagebox with a question icon."));
        
        // Creates a warn dialog
        layout.addComponent(new Label("3"));
        Button warn = new Button("Warn Dialog");
        warn.setWidth("100%");
        layout.addComponent(warn);
        warn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.WARN, "Example 3", "Some important warning!", ButtonId.CLOSE);
			}
			
		});
        layout.addComponent(new Label("Shows a messagebox with a warn icon."));
        
        // Creates a error dialog
        layout.addComponent(new Label("4"));
        Button error = new Button("Error Dialog");
        error.setWidth("100%");
        layout.addComponent(error);
        error.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.ERROR, "Example 4", "The batch job has failed! Do you want to continue?", ButtonId.RETRY, ButtonId.IGNORE, ButtonId.ABORT);
			}
			
		});
        layout.addComponent(new Label("Shows a messagebox with an error icon."));
        
        // Creates a dialog without an icon
        layout.addComponent(new Label("5"));
        Button noIcon = new Button("No Icon Dialog");
        noIcon.setWidth("100%");
        layout.addComponent(noIcon);
        noIcon.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "Example 5", "... without an icon.", ButtonId.OK);
			}
			
		});
        layout.addComponent(new Label("Shows a messagebox without an icon."));
        
        // dialog with event listener
        layout.addComponent(new Label("6"));
        Button event = new Button("Dialog with MessageBoxListener");
        layout.addComponent(event);
        event.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.QUESTION, 
						"Example 6", 
						"Do you really want to continue?", 
						new MessageBoxListener() {
					
							@Override
							public void buttonClicked(ButtonId buttonId) {
								System.out.println("Following button was pressed: " + buttonId);
							}
						}, 
						ButtonId.YES, 
						ButtonId.NO);				
			}
			
		});
        layout.addComponent(new Label("Shows the usage of the MessageBoxListener. The result is printed to console."));
        
        // creates a dialog with custom width
        layout.addComponent(new Label("7"));
        Button customWidth = new Button("Custom size");
        customWidth.setWidth("100%");
        layout.addComponent(customWidth);
        customWidth.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "Example 7", "Size is 500x300 pixel.", ButtonId.OK).setWidth("500px").setHeight("300px");
			}
			
		});
        layout.addComponent(new Label("Shows a dialog witha fixed size of 500x300 pixel."));
        
        // Creates an info dialog
        layout.addComponent(new Label("8"));
        Button longText = new Button("Long Message");
        longText.setWidth("100%");
        layout.addComponent(longText);
        longText.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "Example 9", "Long plain text has to be broken manually with an '\\n':\n1. line\n2. line\n3. line\n4. line\n5. line\n6. line", ButtonId.OK);
			}
			
		});
        layout.addComponent(new Label("Long text expands the window. You have to format your text with '\\n' to force line breaks."));
        
        // Creates a dialog with buttons aligned center
        layout.addComponent(new Label("9"));
        Button buttonCentered = new Button("Buttons centered");
        buttonCentered.setWidth("100%");
        layout.addComponent(buttonCentered);
        buttonCentered.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Example 9", "Now, the Buttons are aligned to the middle.", ButtonId.OK, ButtonId.CANCEL).setButtonAlignment(Alignment.MIDDLE_CENTER);
			}
			
		});
        layout.addComponent(new Label("Buttons are aligned to the middle of the dialog."));
        
        // Creates a dialog with buttons aligned to the left
        layout.addComponent(new Label("10"));
        Button buttonsAlignedLeft = new Button("Buttons aligned to the left");
        buttonsAlignedLeft.setWidth("100%");
        layout.addComponent(buttonsAlignedLeft);
        buttonsAlignedLeft.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Example 10", "Now, the Buttons are aligned to the left.", ButtonId.OK, ButtonId.CANCEL).setButtonAlignment(Alignment.MIDDLE_LEFT);
			}
			
		});
        layout.addComponent(new Label("Buttons are aligned to the left of the dialog."));
        
        // Creates a dialog with buttons aligned to the left
        layout.addComponent(new Label("11"));
        Button customButtonCaptions = new Button("Custom button captions");
        customButtonCaptions.setWidth("100%");
        layout.addComponent(customButtonCaptions);
        customButtonCaptions.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Example 11", "Button captions replaced!", ButtonId.YES, ButtonId.NO);
				mb.getButton(ButtonId.YES).setCaption("Yea");
				mb.getButton(ButtonId.NO).setCaption("Nay");
			}
			
		});
        layout.addComponent(new Label("Shows, how to replace the caption of buttons."));
        
        // Creates a dialog with a spacer between the some buttons
        layout.addComponent(new Label("12"));
        Button spacer = new Button("Buttons with spacer");
        spacer.setWidth("100%");
        layout.addComponent(spacer);
        spacer.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Example 12", "You can use the spacer to group buttons!", ButtonId.YES, ButtonId.NO, ButtonId.SPACER, ButtonId.CLOSE);
			}
			
		});
        layout.addComponent(new Label("Shows, how to put a placeholder between buttons."));
        
        // Creates a dialog with buttons aligned to the left
        layout.addComponent(new Label("13"));
        Button buttonFocus = new Button("Button focused");
        buttonFocus.setWidth("100%");
        layout.addComponent(buttonFocus);
        buttonFocus.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Button focused", "The 'Save' button is focused!", ButtonId.SAVE, ButtonId.CANCEL);
				mb.getButton(ButtonId.SAVE).focus();
			}
			
		});
        layout.addComponent(new Label("Shows, how to focus a button."));
        
        // Message with HTML
        layout.addComponent(new Label("14"));
        Button html = new Button("Message with HTML");
        html.setWidth("100%");
        layout.addComponent(html);
        html.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showHTML(Icon.INFO, "Example 14", "Some HTML: <b>bold</b> <i>italic</i><br/>A new line etc.", ButtonId.CLOSE);
			}
			
		});
        layout.addComponent(new Label("Shows, how to focus a button."));
        
        // Creates a dialog with buttons aligned to the left
        layout.addComponent(new Label("15"));
        Button customButtonWidth = new Button("Custom button width");
        customButtonWidth.setWidth("100%");
        layout.addComponent(customButtonWidth);
        customButtonWidth.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Example 15", "Button with custom width!", ButtonId.YES, ButtonId.NO);
				mb.getButton(ButtonId.NO).setCaption("Really, really no");
				mb.setButtonWidth("150px");
			}
		});
        layout.addComponent(new Label("Shows, how to display an HTML formated message."));
        
        // Custom icon for button and dialog
        layout.addComponent(new Label("16"));
        Button customIcons = new Button("Custom icons");
        customIcons.setWidth("100%");
        layout.addComponent(customIcons);
        customIcons.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(new ClassResource(Demo.class, "acme.png"), "Example 16", "Custom icons used!", ButtonId.YES, ButtonId.NO);
				mb.getButton(ButtonId.YES).setIcon(new ClassResource(Demo.class, "smilie1.png"));
				mb.getButton(ButtonId.NO).setIcon(new ClassResource(Demo.class, "smilie2.png"));
			}
		});
        layout.addComponent(new Label("Shows, how to display custom icons for the dialog itself and the buttons."));
        
        // Custom Component
        layout.addComponent(new Label("17"));
        Button customComponent = new Button("Custom component");
        customComponent.setWidth("100%");
        layout.addComponent(customComponent);
        customComponent.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Panel p = new Panel();
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < 100; i++) {
					sb.append("Lorem ipsum dolor sit amet, consetetur sadipscing elitr.");
				}
				p.setContent(new Label(sb.toString()));
				MessageBox mb = MessageBox.showCustomized(Icon.NONE, "Example 17", p, ButtonId.NO, ButtonId.YES).setWidth("500px").setHeight("300px");
				Button b = mb.getButton(ButtonId.YES);
				b.setCaption("Accept");
				b.focus();
				b = mb.getButton(ButtonId.NO);
				b.setCaption("Decline");
				b.setStyleName(BaseTheme.BUTTON_LINK);
			}
		});
        layout.addComponent(new Label("Shows, how to display a scrollable message with panel."));
        
    }

}

