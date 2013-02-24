package de.steinwedel;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import de.steinwedel.vaadin.MessageBox;
import de.steinwedel.vaadin.MessageBox.ButtonType;
import de.steinwedel.vaadin.MessageBox.EventListener;

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
				 MessageBox mb = new MessageBox("My message ...", 
                         MessageBox.Icon.INFO, 
                         "Hello World!",  
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.show();
			}
		});
        
        // Creates a question dialog
        Button question = new Button("Question Dialog");
        layout.addComponent(question);
        question.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = new MessageBox("Are you sure?", 
                        MessageBox.Icon.QUESTION, 
                        "Do you really want to continue?",  
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.YES, "Yes"),
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.NO, "No"));
				        mb.show();
			}
		});
        
        // Creates a warn dialog
        Button warn = new Button("Warn Dialog");
        layout.addComponent(warn);
        warn.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox("Beware", 
                         MessageBox.Icon.WARN, 
                         "Some important warning!", 
                         new MessageBox.ButtonConfig(ButtonType.YES, "Yes"),
                         new MessageBox.ButtonConfig(ButtonType.CANCEL, "Cancel"));
				 mb.show();
			}
		});
        
       // Creates a error dialog
        Button error = new Button("Error Dialog");
        layout.addComponent(error);
        error.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox("D'oh", 
                         MessageBox.Icon.ERROR, 
                         "The batch job has failed! Do you want to continue?", 
                         new MessageBox.ButtonConfig(ButtonType.RETRY, "Retry"),
                         new MessageBox.ButtonConfig(ButtonType.IGNORE, "Ignore"),
                         new MessageBox.ButtonConfig(ButtonType.ABORT, "Abort"));
				 mb.show();
			}
		});
        
       // Creates a dialog without an icon
        Button noIcon = new Button("No Icon Dialog");
        layout.addComponent(noIcon);
        noIcon.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox("A messagebox", 
                         MessageBox.Icon.NONE, 
                         "... without an icon.", 
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.show();
			}
		});
        
        // dialog with event listener
        Button event = new Button("Dialog with EventListener");
        layout.addComponent(event);
        event.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = new MessageBox("Are you sure?", 
                        MessageBox.Icon.QUESTION, 
                        "Do you really want to continue?",  
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.YES, "Yes"),
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.NO, "No"));
				        mb.show(new EventListener() {
				                                
				                private static final long serialVersionUID = 1L;
				
				                @Override
				                public void buttonClicked(ButtonType buttonType) {
				                        System.out.println("This button was pressed: " + buttonType);
				                }
				        });
			}
		});
        
        // creates a dialog with custom width
        Button customWidth = new Button("custom width");
        layout.addComponent(customWidth);
        customWidth.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox("My message ...", 
                         MessageBox.Icon.INFO, 
                         "Hello World!",  
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.setWidth("500px");
				 mb.show();
			}
		});
        
        // Creates an info dialog
        Button longText = new Button("Long Text");
        layout.addComponent(longText);
        longText.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox("My message ...", 
                         MessageBox.Icon.INFO, 
                         "Bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla - END",  
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.setHeight("200px");
				 mb.show();
			}
		});
        
        
        // Creates an info dialog
        Button test = new Button("test");
        layout.addComponent(test);
        test.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 Window window = new Window("Test");
				 window.setModal(true);
				 VerticalLayout mainLayout;
					HorizontalLayout buttonLayout;
					Button button_3;
					Button button_2;
					Button button_1;
					HorizontalLayout contentLayout;
					Label msgLabel;
					Label iconLabel;
					
					// common part: create layout
					mainLayout = new VerticalLayout();
					mainLayout.setImmediate(false);
					mainLayout.setWidth("-1px");
					mainLayout.setHeight("-1px");
					mainLayout.setMargin(true);
					mainLayout.setSpacing(true);
					
					// top-level component properties
					setWidth("-1px");
					setHeight("-1px");
					
					// horizontalLayout_1
					contentLayout = new HorizontalLayout();
					contentLayout.setImmediate(false);
					contentLayout.setWidth("100.0%");
					contentLayout.setHeight("100.0%");
					contentLayout.setMargin(false);
					contentLayout.setSpacing(true);
					
					// iconLabel
					iconLabel = new Label();
					iconLabel.setImmediate(false);
					iconLabel.setWidth("-1px");
					iconLabel.setHeight("-1px");
					iconLabel.setValue("Label");
					contentLayout.addComponent(iconLabel);
					
					// msgLabel
					msgLabel = new Label();
					msgLabel.setImmediate(false);
					msgLabel.setWidth("100.0%");
					msgLabel.setHeight("100.0%");
					msgLabel.setContentMode(ContentMode.PREFORMATTED);
					msgLabel.setValue("Label Label Label Label Label\n Label Label Label Label Label \nLabel Label Label Label Label \nLabel Label Label Label \nLabel Label Label Label \nLabel Label Label Label Label \nLabel Label Label Label Label Label Label <br>--New Line Label Label  -- ENDE");
					contentLayout.addComponent(msgLabel);
					contentLayout.setExpandRatio(msgLabel, 1.0f);
					mainLayout.addComponent(contentLayout);
					mainLayout.setExpandRatio(contentLayout, 1.0f);
					
					// horizontalLayout_2
					buttonLayout = new HorizontalLayout();
					buttonLayout.setImmediate(false);
					buttonLayout.setWidth("100%");
					buttonLayout.setHeight("-1px");
					buttonLayout.setMargin(false);
					buttonLayout.setSpacing(true);
					
					// button_1
					button_1 = new Button();
					button_1.setCaption("Button");
					button_1.setImmediate(true);
					button_1.setWidth("-1px");
					button_1.setHeight("-1px");
					buttonLayout.addComponent(button_1);
					
					// button_2
					button_2 = new Button();
					button_2.setCaption("Button");
					button_2.setImmediate(true);
					button_2.setWidth("-1px");
					button_2.setHeight("-1px");
					buttonLayout.addComponent(button_2);
					
					// button_3
					button_3 = new Button();
					button_3.setCaption("Button");
					button_3.setImmediate(true);
					button_3.setWidth("-1px");
					button_3.setHeight("-1px");
					buttonLayout.addComponent(button_3);
					
					mainLayout.addComponent(buttonLayout);
					
					window.setContent(mainLayout);
				 
				 UI.getCurrent().addWindow(window);
			}
		});
    }

}

