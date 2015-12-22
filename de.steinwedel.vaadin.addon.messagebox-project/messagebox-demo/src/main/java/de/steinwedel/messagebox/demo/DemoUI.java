package de.steinwedel.messagebox.demo;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
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
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;

import de.steinwedel.messagebox.ButtonOption;
import de.steinwedel.messagebox.MessageBox;

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
			URL url = new URL("http://sourceforge.net/p/messagebox/code/HEAD/tree/trunk/de.steinwedel.vaadin.addon.messagebox-project/messagebox-demo/src/main/java/de/steinwedel/messagebox/demo/DemoUI.java?format=raw");
			URLConnection con = url.openConnection();
			is = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			source = IOUtils.toString(is, encoding);
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
        								+ "\nIf you like this demo, vote for it on the vaadin addon page "
        								+ "\nto honor my work. Thanks!"
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

        addExample("Info Dialog", "Shows a messagebox with an info icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// This is the simplest way to define a dialog.
				
				MessageBox.create().asInfo()
					.withCaption("Info Dialog")
					.withMessage("Hello World!")
					.open();
			}

		});
        addExample("Many buttons", "You can define a lot of buttons. 1, 2, 3 or more buttons are no problem.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You need more than one ore two buttons? No problem ...
				
				MessageBox.create().asInfo()
					.withCaption("Many buttons")
					.withMessage("You can define a lot of buttons. But notice, user don't like overloaded dialogs.")
					.withYesButton()
					.withNoButton()
					.withIgnoreButton()
					.withRetryButton()
					.open();
			}

		});
        addExample("Dialog with MessageBoxListener", "Shows the usage of the MessageBoxListener. The result is displayed as Vaadin Notification.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Till now, the dialogs are very stupid. Here is an example, 
				// how to handle the button click event. 
				
				
				MessageBox.create().asQuestion()
					.withCaption("Dialog with MessageBoxListener")
					.withMessage("Do you really want to continue?")
					.withYesButton(()-> { Notification.show("Yes pressed."); })
					.withNoButton(()-> { Notification.show("No pressed."); })
					.open();
			}
			
		});
        addExample("Buttons with spacer", "Shows, how to put a placeholder between buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can do some eye-candy stuff with a spacer
				
				MessageBox.create().asInfo()
						.withCaption("Buttons with spacer")
						.withMessage("You can use the spacer to group buttons!")
						.withYesButton()
						.withNoButton()
						.withSpacer()
						.withCloseButton()
						.open();
			}
			
		});
        addExample("Question Dialog", "Shows a messagebox with a question icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.create().asQuestion()
					.withCaption("Question Dialog")
					.withMessage("Do you really want to continue?")
					.withYesButton()
					.withNoButton()
					.open();
			}
			
		});
        addExample("Warn Dialog", "Shows a messagebox with a warn icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.create().asWarning()
					.withCaption("Warning Dialog")
					.withMessage("Some important warning!")
					.open();
			}
			
		});
        addExample("Error Dialog", "Shows a messagebox with an error icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.create().asError()
					.withCaption("Error Dialog")
					.withMessage("The batch job has failed! Do you want to continue?")
					.withRetryButton()
					.withIgnoreButton()
					.withAbortButton()
					.open();
			}
			
		});
        addExample("No Icon Dialog", "Shows a messagebox without an icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// If you don't need dialog icon, write following ...
				
				MessageBox.create()
					.withCaption("No Icon Dialog")
					.withMessage("... without an icon.")
					.open();
			}
			
		});
        addExample("Custom size", "Shows a dialog with a fixed size of 500x300 pixel.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Maybe you want to have a fixed size for the dialog. It's simple ...
				
				MessageBox.create()
					.withWidth("500px")
					.withHeight("300px")
					.withCaption("Custom size")
					.withMessage("Size is 500x300 pixel.")
					.open();
			}
			
		});
        addExample("Long message", "Long text expands the window. You have to format your text with '\\n' to force line breaks.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can wrap long messages easily with an \n.
				// The dialog resizes automatically.
				
				MessageBox.create()
					.withCaption("Long message")
					.withMessage("Long plain text has to be broken manually with an '\\n':\n1. line\n2. line\n3. line\n4. line\n5. line\n6. line")
					.open();
			}
			
		});
        addExample("Buttons centered", "Buttons are aligned to the middle of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the default placement. You can change it ...
				
				MessageBox.create().asInfo()
					.withCaption("Buttons centered")
					.withMessage("Now, the Buttons are aligned to the middle.")
					.withOkButton()
					.withCancelButton()					
					.withButtonAlignment(Alignment.MIDDLE_CENTER)
					.open();
			}
			
		});
        addExample("Buttons aligned to the left", "Buttons are aligned to the left of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the default placement. You can change it ...
				
				MessageBox.create().asInfo()
					.withCaption("Buttons left")
					.withMessage("Now, the Buttons are aligned to the left.")
					.withOkButton()
					.withCancelButton()					
					.withButtonAlignment(Alignment.MIDDLE_LEFT)
					.open();
			}
			
		});
        addExample("Custom button captions", "Shows, how to replace the caption of buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Sometimes you need custom button captions. It's so easy.
				
				MessageBox.create().asInfo()
					.withCaption("Custom button captions")
					.withMessage("Button captions replaced!")
					.withYesButton(ButtonOption.caption("Yea"))
					.withNoButton(ButtonOption.caption("Nay"))
					.open();
			}
			
		});
        addExample("Button focused", "Shows, how to focus a button.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// You can focus a button, if required ...
				
				MessageBox.create().asInfo()
					.withCaption("Button focused")
					.withMessage("The 'Save' button is focused!")
					.withSaveButton(ButtonOption.focus())
					.withCancelButton()
					.open();
			}
			
		});
        addExample("Message with HTML", "Shows, how to focus a button.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Plain text is boring you. What about HTML? Better?
				
				MessageBox.create().asInfo()
					.withCaption("Message with HTML")
					.withHtmlMessage("Some HTML: <b>bold</b> <i>italic</i><br/>A new line etc.")
					.open();
			}
			
		});
        addExample("Custom button width", "Shows, how to set a custom button width.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Want to set a unique button width?
				
				MessageBox.create().asInfo()
					.withCaption("Custom button width")
					.withMessage("Button with custom width!")
					.withYesButton()
					.withNoButton(ButtonOption.caption("Really, really no"))
					.withWidthForAllButtons("150px")
					.open();
			}
		});
        addExample("Custom icons", "Shows, how to display custom icons for the dialog itself and the buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Yeay, custom icons. Hope, you can draw better icons than me!
				
				MessageBox.create()
					.withIcon(new Embedded(null, new ClassResource(DemoUI.class, "acme.png"))) // Vaadin knows more options to include an custom image ...
					.withCaption("Custom icons")
					.withMessage("Custom icons used!")
					.withYesButton(ButtonOption.icon(new ClassResource(DemoUI.class, "smilie1.png")))
					.withNoButton(ButtonOption.icon(new ClassResource(DemoUI.class, "smilie2.png")))
					.open();
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
				MessageBox.create()
					.withCaption("Custom component")
					.withMessage(p)
					.withNoButton(ButtonOption.caption("Decline"), ButtonOption.style(BaseTheme.BUTTON_LINK))
					.withYesButton(ButtonOption.caption("Accept"), ButtonOption.focus())
					.withWidth("500px")
					.withHeight("300px")
					.open();
			}
		});
        addExample("Custom placement", "Shows, how to set the placement of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Don't like the centric placement? You can change it ...
				
				MessageBox.create().asInfo()
					.withCaption("Custom placement")
					.withMessage("Placed at x = 50, y = 50.")
					.withDialogPosition(50, 50)
					.open();
			}
		});
        addExample("Switch I18N", "Switches between german and english locale.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// I18N is even supported. It uses the default mechanism from Java.
				// You can support me with further languages. But please, no
				// google translate stuff!
				
				MessageBox.create().asQuestion()
					.withCaption("Switch I18N")
					.withHtmlMessage("Switch the internationalization. The demo shows German and English language supported.<br>Call <i><code>MessageBox.RESOURCES_FACTORY.setResourceBundle(<basename>);</code></i> for using your own resource bundle.")
					.withCustomButton(() -> { 
						MessageBox.setDialogDefaultLanguage(Locale.GERMAN); 
						Notification.show("Button captions are now german.", "", Notification.Type.WARNING_MESSAGE); 
						}, ButtonOption.icon(new ClassResource(DemoUI.class, "german.png")), ButtonOption.caption("German"))
					.withCustomButton(() -> { 
						MessageBox.setDialogDefaultLanguage(Locale.ENGLISH); 
						Notification.show("Button captions are now engish.", "", Notification.Type.WARNING_MESSAGE); 
						}, ButtonOption.icon(new ClassResource(DemoUI.class, "english.png")), ButtonOption.caption("English"))
					.open();
			}
			
		});
        addExample("Help button", "Shows the behavior of the help button that differs from all other buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// The help button does not close the message dialog like other
				// buttons. Typically, you open a help window keeping the 
				// current messagebox open. In this example the help dialog is 
				// even a messagebox. A special feature of the help dialog is
				// that it is non-modal. You can make a messagebox non-modal
				// with calling setModal(false).
				
				MessageBox mb = MessageBox.create();
				mb.asInfo()
					.withCaption("Help Button")
					.withMessage("The dialog does not close the message dialog. Other buttons do!")
					.withCloseButton(() -> {
						if (mb.getData() != null) {
							MessageBox helpMB = (MessageBox) mb.getData();
							helpMB.close();
						}
					})
					.withHelpButton(() -> {
						MessageBox helpMB = MessageBox.create();
						helpMB.asModal(false)
							.withCaption("Help")
							.withMessage("Here, you can explain something.\nThis dialog does not need to be a messagebox,\nbut you can use it, if you like.")
							.withDialogPosition(mb.getWindow().getPositionX() + 500, mb.getWindow().getPositionY())
							.withCloseButton(() -> { mb.setData(null); })
							.open();
						mb.setData(helpMB);
					})
					.open();
			}
		});
        addExample("Disable auto-close", "You can disable the auto-closing of the dialog.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			private int count;
			private MessageBox mb;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// If you want to implement in the listener yourself
				// when the dialog is closed, call setAutoClose(false).
				
				count = 0;
				
				mb = MessageBox.create().asInfo()
						.withCaption("Disable auto-close")
						.withMessage("You must click the button twice to close the dialog.")
						.withCloseButton(() -> {								
							if (++count >= 2) mb.close();
							Notification.show("Button clicks: " + count, "", Notification.Type.WARNING_MESSAGE);
						}, ButtonOption.closeOnClick(false));
				mb.open();
			}
		});

    }

}
