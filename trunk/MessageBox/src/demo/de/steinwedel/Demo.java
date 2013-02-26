package de.steinwedel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
        VerticalLayout layout = new VerticalLayout();
        setContent(layout);
        layout.setMargin(true);
        layout.setSpacing(true);

        // Creates an info dialog
        Button info = new Button("Info Dialog");
        layout.addComponent(info);
        info.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox.showPlain(Icon.INFO, "My message ...", "Hello World!", ButtonId.OK);
			}
			
		});
        
        // Creates a question dialog
        Button question = new Button("Question Dialog");
        layout.addComponent(question);
        question.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.QUESTION, "Are you sure?", "Do you really want to continue?", ButtonId.YES, ButtonId.NO);
			}
			
		});
        
        // Creates a warn dialog
        Button warn = new Button("Warn Dialog");
        layout.addComponent(warn);
        warn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.WARN, "Beware", "Some important warning!", ButtonId.CLOSE);
			}
			
		});
        
        // Creates a error dialog
        Button error = new Button("Error Dialog");
        layout.addComponent(error);
        error.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.ERROR, "D'oh", "The batch job has failed! Do you want to continue?", ButtonId.RETRY, ButtonId.IGNORE, ButtonId.ABORT);
			}
		});
        
        // Creates a dialog without an icon
        Button noIcon = new Button("No Icon Dialog");
        layout.addComponent(noIcon);
        noIcon.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "A messagebox", "... without an icon.", ButtonId.OK);
			}
		});
        
        // dialog with event listener
        Button event = new Button("Dialog with EventListener");
        layout.addComponent(event);
        event.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.QUESTION, 
						"Are you sure?", 
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
        
        // creates a dialog with custom width
        Button customWidth = new Button("Custom size");
        layout.addComponent(customWidth);
        customWidth.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "Forced width & height", "Size is 500x300 pixel.", ButtonId.OK).setWidth("500px").setHeight("300px");
			}
		});
        
        // Creates an info dialog
        Button longText = new Button("Long Message");
        layout.addComponent(longText);
        longText.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.NONE, "A long message ...", "Long plain text has to be wrapped manually with an '\\n':\n1. line\n2. line\n3. line\n4. line\n5. line\n6. line", ButtonId.OK);
			}
		});
        
        // Creates a dialog with buttons aligned center
        Button buttonCentered = new Button("Buttons centered");
        layout.addComponent(buttonCentered);
        buttonCentered.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Centered", "Now, the Buttons are aligned to the middle.", ButtonId.OK, ButtonId.CANCEL).setButtonAlignment(Alignment.MIDDLE_CENTER);
			}
		});
        
        // Creates a dialog with buttons aligned to the left
        Button buttonsAlignedLeft = new Button("Buttons aligned to the left");
        layout.addComponent(buttonsAlignedLeft);
        buttonsAlignedLeft.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Left", "Now, the Buttons are aligned to the left.", ButtonId.OK, ButtonId.CANCEL).setButtonAlignment(Alignment.MIDDLE_LEFT);
			}
		});
        
        // Creates a dialog with buttons aligned to the left
        Button customButtonCaptions = new Button("Custom button captions");
        layout.addComponent(customButtonCaptions);
        customButtonCaptions.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Custom button captions", "Please replace the values in the map\nde.steinwedel.messagebox.DefaultResources.BUTTON_CAPTION\nto change the default!", ButtonId.YES, ButtonId.NO);
				mb.getButton(ButtonId.YES).setCaption("Yea");
				mb.getButton(ButtonId.NO).setCaption("Nay");
			}
		});
        
        // Creates a dialog with a spacer between the some buttons
        Button spacer = new Button("Buttons with spacer");
        layout.addComponent(spacer);
        spacer.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showPlain(Icon.INFO, "Using spacer", "You can use the spacer to group buttons!", ButtonId.YES, ButtonId.NO, ButtonId.SPACER, ButtonId.CLOSE);
			}
		});
        
        // Creates a dialog with buttons aligned to the left
        Button buttonFocus = new Button("Button focused");
        layout.addComponent(buttonFocus);
        buttonFocus.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Button focused", "The 'Save' button is focused!", ButtonId.SAVE, ButtonId.CANCEL);
				mb.getButton(ButtonId.SAVE).focus();
			}
		});
        
        // Message with HTML
        Button html = new Button("Message with HTML");
        layout.addComponent(html);
        html.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox.showHTML(Icon.INFO, "HTML message", "Some HTML: <b>bold</b> <i>italic</i><br/>A new line etc.", ButtonId.CLOSE);
			}
		});
        
        // Creates a dialog with buttons aligned to the left
        Button customButtonWidth = new Button("Custom button width");
        layout.addComponent(customButtonWidth);
        customButtonWidth.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = MessageBox.showPlain(Icon.INFO, "Custom button width", "Button with custom width!", ButtonId.YES, ButtonId.NO);
				mb.getButton(ButtonId.NO).setCaption("Really, really no");
				mb.setButtonWidth("150px");
			}
		});
        
        // Custom icon for button and dialog
        
        // Custom Component
        
    }

}

