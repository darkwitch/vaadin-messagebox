package de.steinwedel;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

import de.steinwedel.vaadin.MessageBox;
import de.steinwedel.vaadin.MessageBox.ButtonType;
import de.steinwedel.vaadin.MessageBox.EventListener;

/**
 * Demo Application for messagesboxes.
 * URL: http://localhost:8080/MessageBox/?restartApplication
 */
public class Demo extends Application {

	private static final long serialVersionUID = 1L;

	@Override
    public void init() {
        Window mainWindow = new Window("MessageBox Demo Application");

        // Creates an info dialog
        Button info = new Button("Info Dialog");
        mainWindow.addComponent(info);
        info.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                         "My message ...", 
                         MessageBox.Icon.INFO, 
                         "Hello World!",  
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.show();
			}
		});
        
        // Creates a question dialog
        Button question = new Button("Question Dialog");
        mainWindow.addComponent(question);
        question.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                        "Are you sure?", 
                        MessageBox.Icon.QUESTION, 
                        "Do you really want to continue?",  
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.YES, "Yes"),
                        new MessageBox.ButtonConfig(MessageBox.ButtonType.NO, "No"));
				        mb.show();
			}
		});
        
        // Creates a warn dialog
        Button warn = new Button("Warn Dialog");
        mainWindow.addComponent(warn);
        warn.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                         "Beware", 
                         MessageBox.Icon.WARN, 
                         "Some important warning!", 
                         new MessageBox.ButtonConfig(ButtonType.YES, "Yes"),
                         new MessageBox.ButtonConfig(ButtonType.CANCEL, "Cancel"));
				 mb.show();
			}
		});
        
       // Creates a error dialog
        Button error = new Button("Error Dialog");
        mainWindow.addComponent(error);
        error.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                         "D'oh", 
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
        mainWindow.addComponent(noIcon);
        noIcon.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                         "A messagebox", 
                         MessageBox.Icon.NONE, 
                         "... without an icon.", 
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.show();
			}
		});
        
        // dialog with event listener
        Button event = new Button("Dialog with EventListener");
        mainWindow.addComponent(event);
        event.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                        "Are you sure?", 
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
        mainWindow.addComponent(customWidth);
        customWidth.addListener(new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				 MessageBox mb = new MessageBox(Demo.this.getMainWindow(), 
                         "My message ...", 
                         MessageBox.Icon.INFO, 
                         "Hello World!",  
                         new MessageBox.ButtonConfig(ButtonType.OK, "Ok"));
				 mb.setWidth("500px");
				 mb.show();
			}
		});
        
        // set main window
        setMainWindow(mainWindow);
    }

}

