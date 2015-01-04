package de.steinwedel.messagebox.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.AceTheme;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;

import de.steinwedel.messagebox.ButtonId;
import de.steinwedel.messagebox.Icon;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.MessageBoxListener;

@Theme("demo")
@Title("MessageBox Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

	private int index = 1;
	private GridLayout layout;
	private String source;
	private AceEditor implementationEditor;
	
	private void addExample(String buttonCaption, String description, ClickListener listener) {
		Label indexLabel = new Label(Integer.toString(index));
        layout.addComponent(indexLabel);
        
        Button demoButton = new Button(buttonCaption);
        demoButton.setWidth("210px");
        demoButton.addClickListener(listener);
        layout.addComponent(demoButton);

        Label descriptionLabel = new Label(description);
        layout.addComponent(descriptionLabel);
        
        Pattern pattern = Pattern.compile("addExample\\(\"" + buttonCaption + ".*?\\}\\);", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
        	String outerBlock = source.substring(matcher.start(), matcher.end());
        	pattern = Pattern.compile("public void buttonClick\\(ClickEvent event\\) \\{(.*)\\}.+\\}\\);", Pattern.DOTALL);
        	matcher = pattern.matcher(outerBlock);
        	if (matcher.find()) {
        		String innerBlock = outerBlock.substring(matcher.start(1), matcher.end(1));
        		final String implementation = innerBlock.replaceAll("\n\t\t\t\t", "\n").replaceAll("\n\t*$", "\n");
        		demoButton.addClickListener(new ClickListener() {
					
					@Override
					public void buttonClick(ClickEvent event) {
						implementationEditor.setMode(AceMode.java);
						implementationEditor.setReadOnly(false);
						implementationEditor.setValue(implementation);
						implementationEditor.setReadOnly(true);
					}
				});
        	}
        }
        
		index++;
	}
	
	private void loadSource() {
		InputStream is = null;
		source = "";
		try {
			is = this.getClass().getResource("DemoUI.java").openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			int result = bis.read();
			while (result != -1) {
				byte b = (byte) result;
				buf.write(b);
				result = bis.read();
			}
			source = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { is.close(); } catch (Throwable e) {}
		}
	}
	
	@Override
    public void init(VaadinRequest request) {
    	loadSource();
		
		getPage().setTitle("MessageBox Demo Application");
        layout = new GridLayout();
        HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
        splitPanel.setFirstComponent(layout);
        splitPanel.setSecondComponent(implementationEditor = new AceEditor());
        splitPanel.setSplitPosition(760f, Unit.PIXELS);
        setContent(splitPanel);
        
        implementationEditor.setWidth("100%");
        implementationEditor.setHeight("100%");
        implementationEditor.setMode(AceMode.text);
        implementationEditor.setTheme(AceTheme.eclipse);
        implementationEditor.setValue(    "\nWELCOME"
        								+ "\n======="
        								+ "\nWelcome to the demo and idea site for the MessageBox widget."
        								+ "\nYou will find here a lot examples, how to use the MessageBox."
        								+ "\nI hope, the examples inspire you."
        								+ "\n"
        								+ "\nIf you like this demo, vote for it on the vaadin addon page. Thanks!"
        								+ "\n"
        								+ "\n"
        								+ "\nHOW TO USE IT"
        								+ "\n============="
        								+ "\nSimply press on the left side in the column 'Demo' a button "
        								+ "\nto open an demo dialog."
        								+ "\n"
        								+ "\nThis text will be replaced with the corresponding implementation,"
        								+ "\nwhen you press a button."
        								+ "\n");
        implementationEditor.setReadOnly(true);
        
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setColumns(3);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        
        layout.addComponent(new Label("<b>No</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Demo</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Description</b>", ContentMode.HTML));
        
        // Force locale "English"
        MessageBox.RESOURCE_FACTORY.setResourceLocale(Locale.ENGLISH);

        addExample("Info Dialog", "Shows a messagebox with an info icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// This is the simplest way to define a dialog.
				
				MessageBox.showPlain(
						Icon.INFO, 
						"Info Dialog", 
						"Hello World!", 
						ButtonId.OK);
			}
			
		});
        addExample("Many buttons", "You can define a lot of buttons. 1, 2, 3 or more buttons are no problem.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You need more than one ore two buttons? No problem ...
				
				MessageBox.showPlain(
						Icon.INFO, 
						"Many buttons", 
						"You can define a lot of buttons. But notice, user don't like overloaded dialogs.", 
						ButtonId.YES, ButtonId.NO, ButtonId.IGNORE, ButtonId.RETRY, ButtonId.HELP);
			}
			
		});
        addExample("Dialog with MessageBoxListener", "Shows the usage of the MessageBoxListener. The result is displayed as Vaadin Notification.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Till now, the dialogs are very stupid. Here is an example, 
				// how to handle the button click event. 
				
				MessageBox.showPlain(
						Icon.QUESTION, 
						"Dialog with MessageBoxListener", 
						"Do you really want to continue?", 
						new MessageBoxListener() {
					
							@Override
							public void buttonClicked(ButtonId buttonId) {
								Notification.show("Button pressed.",
						                  "You have pressed the button: " + buttonId.name(),
						                  Notification.Type.WARNING_MESSAGE);
							}
						}, 
						ButtonId.YES, 
						ButtonId.NO);				
			}
			
		});
        addExample("Buttons with spacer", "Shows, how to put a placeholder between buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can do some eye-candy stuff with a spacer
				
				MessageBox.showPlain(
						Icon.INFO, 
						"Buttons with spacer", 
						"You can use the spacer to group buttons!", 
						ButtonId.YES, 
						ButtonId.NO, 
						ButtonId.SPACER, 
						ButtonId.CLOSE);
			}
			
		});
        addExample("Question Dialog", "Shows a messagebox with a question icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.showPlain(
						Icon.QUESTION, 
						"Question Dialog", 
						"Do you really want to continue?", 
						ButtonId.YES, 
						ButtonId.NO);
			}
			
		});
        addExample("Warn Dialog", "Shows a messagebox with a warn icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.showPlain(
						Icon.WARN, 
						"Warn Dialog", 
						"Some important warning!", 
						ButtonId.CLOSE);
			}
			
		});
        addExample("Error Dialog", "Shows a messagebox with an error icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.showPlain(
						Icon.ERROR, 
						"Error Dialog", 
						"The batch job has failed! Do you want to continue?", 
						ButtonId.RETRY, 
						ButtonId.IGNORE, 
						ButtonId.ABORT);
			}
			
		});
        addExample("No Icon Dialog", "Shows a messagebox without an icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// If you don't need dialog icon, write following ...
				
				MessageBox.showPlain(
						Icon.NONE, 
						"No Icon Dialog", 
						"... without an icon.", 
						ButtonId.OK);
			}
			
		});
        addExample("Custom size", "Shows a dialog with a fixed size of 500x300 pixel.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Maybe you want to have a fixed size for the dialog. It's simple ...
				
				MessageBox.showPlain(
						Icon.NONE, 
						"Custom size", 
						"Size is 500x300 pixel.", 
						ButtonId.OK)
					.setWidth("500px")
					.setHeight("300px");
			}
			
		});
        addExample("Long message", "Long text expands the window. You have to format your text with '\\n' to force line breaks.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can wrap long messages easily with an \n.
				// The dialog resizes automatically.
				
				MessageBox.showPlain(
						Icon.NONE, 
						"Long message", 
						"Long plain text has to be broken manually with an '\\n':\n1. line\n2. line\n3. line\n4. line\n5. line\n6. line", 
						ButtonId.OK);
			}
			
		});
        addExample("Buttons centered", "Buttons are aligned to the middle of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the default placement. You can change it ...
				
				MessageBox.showPlain(
						Icon.INFO, 
						"Buttons centered", 
						"Now, the Buttons are aligned to the middle.", 
						ButtonId.OK, 
						ButtonId.CANCEL)
					.setButtonAlignment(Alignment.MIDDLE_CENTER);
			}
			
		});
        addExample("Buttons aligned to the left", "Buttons are aligned to the left of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the default placement. You can change it ...
				
				MessageBox.showPlain(
						Icon.INFO, 
						"Buttons aligned to the left", 
						"Now, the Buttons are aligned to the left.", 
						ButtonId.OK, 
						ButtonId.CANCEL)
					.setButtonAlignment(Alignment.MIDDLE_LEFT);
			}
			
		});
        addExample("Custom button captions", "Shows, how to replace the caption of buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Sometimes you need custom button captions. It's so easy.
				
				MessageBox mb = MessageBox.showPlain(
						Icon.INFO, 
						"Custom button captions", 
						"Button captions replaced!", 
						ButtonId.YES, 
						ButtonId.NO);
				
				// Set the captions ...
				mb.getButton(ButtonId.YES).setCaption("Yea");
				mb.getButton(ButtonId.NO).setCaption("Nay");
			}
			
		});
        addExample("Button focused", "Shows, how to focus a button.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can focus a button, if required ...
				
				MessageBox mb = MessageBox.showPlain(
						Icon.INFO, 
						"Button focused", 
						"The 'Save' button is focused!", 
						ButtonId.SAVE, 
						ButtonId.CANCEL);
				mb.getButton(ButtonId.SAVE).focus();
			}
			
		});
        addExample("Message with HTML", "Shows, how to focus a button.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Plain text is boring you. What about HTML? Better?
				
				MessageBox.showHTML(
						Icon.INFO, 
						"Message with HTML", 
						"Some HTML: <b>bold</b> <i>italic</i><br/>A new line etc.", 
						ButtonId.CLOSE);
			}
			
		});
        addExample("Custom button width", "Shows, how to set a custom button width.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Want to set a unique button width?
				
				MessageBox mb = MessageBox.showPlain(
						Icon.INFO, 
						"Custom button width", 
						"Button with custom width!", 
						ButtonId.YES, 
						ButtonId.NO);
				
				mb.getButton(ButtonId.NO).setCaption("Really, really no");
				mb.setButtonWidth("150px");
			}
		});
        addExample("Custom icons", "Shows, how to display custom icons for the dialog itself and the buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Yeah, custom icons. Hope, you can draw better icons than me!
				
				MessageBox mb = MessageBox.showPlain(
						new ClassResource(DemoUI.class, "acme.png"), // Vaadin knows more options to include an custom image ...
						"Custom icons", 
						"Custom icons used!", 
						ButtonId.YES, 
						ButtonId.NO);
				
				// Customize the icons of the Buttons
				mb.getButton(ButtonId.YES).setIcon(new ClassResource(DemoUI.class, "smilie1.png"));
				mb.getButton(ButtonId.NO).setIcon(new ClassResource(DemoUI.class, "smilie2.png"));
			}
		});
        addExample("Custom component", "Shows, how to display a scrollable message with panel.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can do wired things with the dialog like adding widgets ...
				
				// Create a panel with content
				Panel p = new Panel();
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i < 100; i++) {
					sb.append("Lorem ipsum dolor sit amet, consetetur sadipscing elitr.");
				}
				p.setContent(new Label(sb.toString()));
				
				// Create the messagebox and add the panel
				MessageBox mb = MessageBox.showCustomized(
						Icon.NONE, "Custom component", 
						p, 
						ButtonId.NO, 
						ButtonId.YES)
					.setWidth("500px")
					.setHeight("300px");
				
				// Customize the Buttons
				Button b = mb.getButton(ButtonId.YES);
				b.setCaption("Accept");
				b.focus();
				b = mb.getButton(ButtonId.NO);
				b.setCaption("Decline");
				b.setStyleName(BaseTheme.BUTTON_LINK);
			}
		});
        addExample("Custom placement", "Shows, how to set the placement of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the centric placement? You can change it ...
				
				MessageBox mb = MessageBox.showPlain(
						Icon.INFO, 
						"Custom placement", 
						"Placed at x = 50, y = 50.", 
						ButtonId.CLOSE);
				mb.getWindow().setPositionX(50);
				mb.getWindow().setPositionY(50);
			}
		});
        addExample("Switch I18N", "Switches between german and english locale.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// I18N is even supported. It uses the default mechanism from Java.
				// You can support me with further languages. But please, no
				// google translate stuff!
				
				// Some boilerplate code ...
				MessageBox mb = MessageBox.showPlain(Icon.QUESTION, 
						"Switch I18N", 
						"Switch the internationalization. Currently are German and English supported.\nCall 'MessageBox.RESOURCES_FACTORY.setResourceBundle(<basename>);' for using your own resource bundle.", 
						new MessageBoxListener() {
					
							@Override
							public void buttonClicked(ButtonId buttonId) {
								if (ButtonId.CUSTOM_1.equals(buttonId)) {
									// The next instruction changes the locale to German
									MessageBox.RESOURCE_FACTORY.setResourceLocale(Locale.GERMAN);
									// You can use MessageBox.RESOURCES_FACTORY.setResourceBundle(<basename>); to localize to your language
									Notification.show("Button captions are now german.", "", Notification.Type.WARNING_MESSAGE);
								} else {
									// The next instruction changes the locale to English
									MessageBox.RESOURCE_FACTORY.setResourceLocale(Locale.ENGLISH);
									// You can use MessageBox.RESOURCES_FACTORY.setResourceBundle(<basename>); to localize to your language
									Notification.show("Button captions are now english.", "", Notification.Type.WARNING_MESSAGE);
								}
							}
						}, 
						ButtonId.CUSTOM_1, 
						ButtonId.CUSTOM_2);
				mb.getButton(ButtonId.CUSTOM_1).setCaption("German");
				mb.getButton(ButtonId.CUSTOM_2).setCaption("English");
			}
			
		});
    }

}
