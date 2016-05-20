package de.steinwedel.messagebox.demo;

import java.io.InputStream;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.AceTheme;
import org.vaadin.jouni.animator.Animator;
import org.vaadin.jouni.dom.Dom;
import org.vaadin.jouni.dom.client.Css;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.ClassResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.BaseTheme;

import de.steinwedel.messagebox.ButtonOption;
import de.steinwedel.messagebox.MessageBox;
import de.steinwedel.messagebox.TransitionListener;
import de.steinwedel.messagebox.icons.ClassicButtonIconFactory;
import de.steinwedel.messagebox.icons.ClassicDialogIconFactory;
import de.steinwedel.messagebox.icons.FlatDialogIconFactory;
import de.steinwedel.messagebox.icons.FontAwesomeButtonIconFactory;
import de.steinwedel.messagebox.icons.FontAwesomeDialogIconFactory;

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
			is = getClass().getResourceAsStream(getClass().getSimpleName() + ".java");
			source = IOUtils.toString(is, "UTF-8");
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
        								+ "\nWelcome to the demo and idea site for the MessageBox addon."
        								+ "\nYou will find here a lot examples, how to use the MessageBox."
        								+ "\nI hope, the examples inspire you."
        								+ "\n"
        								+ "\nIf you like this demo, vote for it on the vaadin addon page "
        								+ "\nto honor my work. Thanks!"
        								+ "\n"
        								+ "\nIn version 3.0.0 a new syntax is introduced. The idiom is called"
        								+ "\n'method chaining'. It is intuitively to write and the"
        								+ "\nresulting code is very expressive and narrative."
        								+ "\n"
        								+ "\nI hope, you also like the new syntax."
        								+ "\n"
        								+ "\n"
        								+ "\nHOW TO USE THE DEMO"
        								+ "\n==================="
        								+ "\nSimply press on the left side in the column 'Demo' a button "
        								+ "\nto open an demo dialog."
        								+ "\n"
        								+ "\nThis text will be replaced with the corresponding implementation,"
        								+ "\nwhen you press a button."
        								+ "\n"
        								+ "\n"
        								+ "\nHOW YOU CAN CONTRIBUTE"
        								+ "\n======================"
        								+ "\nIf you want to contribute, please use the forum of sourceforge.net,"
        								+ "\nwhere the project is hosted:"
        								+ "\n"
        								+ "\nhttp://sourceforge.net/p/messagebox/discussion/general/"
        								+ "\n"
        								+ "\nPlease remember, I don't publish my email."
        								+ "\n");
        implementationEditor.setReadOnly(true);
        
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setColumns(3);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        
        layout.addComponent(new Label("<b>No</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Demo</b>", ContentMode.HTML));
        layout.addComponent(new Label("<b>Description</b>", ContentMode.HTML));

        addExample("Info Dialog", "Shows a MessageBox with an info icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// This is the simplest way to define a dialog.
				// If you don't add a button, a close button is 
				// automatically added to the dialog.
				
				MessageBox.createInfo()
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
				
				MessageBox.createInfo()
					.withCaption("Many buttons")
					.withMessage("You can define a lot of buttons. But notice, user don't like overloaded dialogs.")
					.withYesButton()
					.withNoButton()
					.withIgnoreButton()
					.withRetryButton()
					.withSaveButton()
					.open();
			}

		});
        addExample("Dialog with MessageBoxListener", "Shows the usage of the MessageBoxListener. The result is displayed as Vaadin Notification.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// Till now, the dialogs were very stupid. Here is an example, 
				// how to handle the button click event. The example uses
				// lambda expressions from Java 8. But you can even use the
				// classical inner class idiom ...
				//
				// The event handler simply instances of java.lang.Runnable.
				
				
				MessageBox.createQuestion()
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
				
				MessageBox.createInfo()
						.withCaption("Buttons with spacer")
						.withMessage("You can use the spacer to group buttons!")
						.withYesButton()
						.withNoButton()
						.withSpacer()
						.withCloseButton()
						.open();
			}
			
		});
        addExample("Question Dialog", "Shows a MessageBox with a question icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.createQuestion()
					.withCaption("Question Dialog")
					.withMessage("Do you really want to continue?")
					.withYesButton()
					.withNoButton()
					.open();
			}
			
		});
        addExample("Warn Dialog", "Shows a MessageBox with a warn icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.createWarning()
					.withCaption("Warning Dialog")
					.withMessage("Some important warning!")
					.open();
			}
			
		});
        addExample("Error Dialog", "Shows a MessageBox with an error icon.", new ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				// An different dialog icon ...
				
				MessageBox.createError()
					.withCaption("Error Dialog")
					.withMessage("The batch job has failed! Do you want to continue?")
					.withRetryButton()
					.withIgnoreButton()
					.withAbortButton()
					.open();
			}
			
		});
        addExample("No Icon Dialog", "Shows a MessageBox without an icon.", new ClickListener() {

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
				// You don't like the default placement? You can change it ...
				//
				// You can change the default behavior on calling 
				// MessageBox.setButtonDefaultAlignment(Alignment.MIDDLE_CENTER)
				
				MessageBox.createInfo()
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
				// You don't like the default placement? You can change it ...
				//
				// You can change the default behavior on calling 
				// MessageBox.setButtonDefaultAlignment(Alignment.MIDDLE_LEFT)
				
				MessageBox.createInfo()
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
				// Sometimes you may need custom button captions. It's so easy.
				
				MessageBox.createInfo()
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
				
				MessageBox.createInfo()
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
				
				MessageBox.createInfo()
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
				
				MessageBox.createInfo()
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
				
				// Create the MessageBox and add the panel
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
				
				MessageBox.createInfo()
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
				// Currently, more than 40 languages are supported!
				//
				// With MessageBox.setDialogDefaultLanguage(Locale.XYZ) you can
				// can apply default language. Default is english.
				
				MessageBox.createQuestion()
					.withCaption("Switch I18N")
					.withHtmlMessage("Switch the internationalization. The demo shows German and English language supported.<br>Call <i><code>MessageBox.RESOURCES_FACTORY.setResourceBundle(<basename>);</code></i> for using your own resource bundle.")
					.withCustomButton(() -> { 
						MessageBox.setDialogSessionLanguage(Locale.GERMAN); 
						Notification.show("Button captions are now german.", "", Notification.Type.WARNING_MESSAGE); 
						}, ButtonOption.icon(new ClassResource(DemoUI.class, "german.png")), ButtonOption.caption("German"))
					.withCustomButton(() -> { 
						MessageBox.setDialogSessionLanguage(Locale.ENGLISH); 
						Notification.show("Button captions are now english.", "", Notification.Type.WARNING_MESSAGE); 
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
				// current MessageBox open. In this example the help dialog is 
				// even a MessageBox. A special feature of the help dialog is
				// that it is non-modal. You can make a MessageBox non-modal
				// with calling setModal(false).
				
				MessageBox mgBx = MessageBox.createInfo();
				mgBx.withCaption("Help Button")
					.withMessage("The dialog does not close the message dialog. Other buttons do!")
					.withCloseButton(() -> {
						if (mgBx.getData() != null) {
							MessageBox helpMB = (MessageBox) mgBx.getData();
							helpMB.close();
						}
					})
					.withHelpButton(() -> {
						MessageBox helpMB = MessageBox.create();
						helpMB.asModal(false)
							.withCaption("Help")
							.withMessage("Here, you can explain something.\nThis dialog does not need to be a MessageBox,\nbut you can use it, if you like.")
							.withDialogPosition(mgBx.getWindow().getPositionX() + 500, mgBx.getWindow().getPositionY())
							.withCloseButton(() -> { mgBx.setData(null); })
							.open();
						mgBx.setData(helpMB);
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
				
				mb = MessageBox.createInfo()
						.withCaption("Disable auto-close")
						.withMessage("You must click the button twice to close the dialog.")
						.withCloseButton(() -> {								
							if (++count >= 2) mb.close();
							Notification.show("Button clicks: " + count, "", Notification.Type.WARNING_MESSAGE);
						}, ButtonOption.closeOnClick(false));
				mb.open();
			}
		});
        addExample("En-/disable default icons", "You can enable and disable the default icons of the buttons.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// You can enable and disable the icons very easily.
				MessageBox.createQuestion()
						.withCaption("Default icons")
						.withMessage("Should the button icons be enabled?")
						.withYesButton(() -> { MessageBox.setButtonDefaultIconsVisible(true); })
						.withNoButton(() -> { MessageBox.setButtonDefaultIconsVisible(false); })
						.open();
			}
		});
        addExample("Text input", "You can simply add a input field.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// You need a text input? No problem ...
				
				TextField input = new TextField("How do you feel?");
				
				MessageBox.createQuestion()
						.withCaption("Text input")
						.withMessage(input)
						.withOkButton(() -> { Notification.show("You feel " + input.getValue(), "", Notification.Type.WARNING_MESSAGE); })
						.withCancelButton()
						.open();
			}
		});
        addExample("Transistion effects", "You can add transition effects to the MessageBox.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// With the TransitionListener you can intercept the
				// opening and closing of the dialog.
				
				TransitionListener tl = new TransitionListener () {
					
					public boolean show(MessageBox messageBox) {
						new Dom(messageBox.getWindow()).getStyle().opacity(0f);
						Animator.animate(messageBox.getWindow(), new Css().opacity(1f)).duration(300);
						return true;
					}
					
					public boolean close(MessageBox messageBox) {
						// Unfortunally, the addon "Animator" does not offer a public event listener for finishing an animation.
						// Therefore, we cannot animate the close :-(
						return true;
					}
				};
				
				MessageBox.createQuestion()
						.withCaption("Dialog animation")
						.withMessage("Should be the dialog animation enabled?")
						.withYesButton(() -> { MessageBox.setDialogDefaultTransitionListener(tl); })
						.withNoButton(() -> { MessageBox.setDialogDefaultTransitionListener(null); })
						.open();
			}
		});
        addExample("Dialog icon set", "You can switch the dialog icon set.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// You can simply switch the dialog set.
				// You can switch to an own icon sets in the same way.
				//
				// IMPORTANT
				// =========
				// If you are using "FontAwesome", the default color of the icons is black.
				// You can customize the color of all icons in the css.
				// The corresponding selectors are "v-label-infoIcon", "v-label-questionIcon", 
				// "v-label-warningIcon", "v-label-errorIcon". This example uses following css:
				// 
				// .v-label-questionIcon, .v-label-infoIcon {
				// 		color: #0080B0;
				// }
				//
				// .v-label-warningIcon, .v-label-errorIcon {
				// 		color: #E00000;
				// }
				
				MessageBox.createQuestion()
						.withCaption("Dialog icon set")
						.withMessage("Which icon set should be used?")
						.withCustomButton(() -> { MessageBox.setDialogDefaultIconFactory(new ClassicDialogIconFactory()); }, ButtonOption.caption("Classic"))
						.withCustomButton(() -> { MessageBox.setDialogDefaultIconFactory(new FlatDialogIconFactory()); }, ButtonOption.caption("Flat"))
						.withCustomButton(() -> { MessageBox.setDialogDefaultIconFactory(new FontAwesomeDialogIconFactory()); }, ButtonOption.caption("FontAwesome"))
						.open();
			}
		});
        
        addExample("Button icon set", "You can switch the button icon set.", new ClickListener() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void buttonClick(ClickEvent event) {
				// You can simply switch the dialog set.
				// You can switch to an own icon sets in the same way. 
				//
				// IMPORTANT
				// =========
				// If you are using "FontAwesome", the default color of the icons is black. 
				// You can customize the color of all icons in the css.
				// The corresponding selectors are "v-button-messageBoxIcon" for all button icons and
				// "v-button-<ButtonType>Icon" for a specific ButtonType. This example uses following css:
				// 
				// .v-button-messageBoxIcon .v-icon {
				//		color: #0080B0; /* blue for all buttons */
				// }
				//
				// .v-button-closeIcon .v-icon {
				//		color: #000000; /* black for the close button */
				// }

				MessageBox.createQuestion()
						.withCaption("Button icon set")
						.withMessage("Which icon set should be used?")
						.withCustomButton(() -> { MessageBox.setButtonDefaultIconFactory(new ClassicButtonIconFactory()); }, ButtonOption.caption("Classic"))
						.withCustomButton(() -> { MessageBox.setButtonDefaultIconFactory(new FontAwesomeButtonIconFactory()); }, ButtonOption.caption("FontAwesome"))
						.open();
			}
		});

    }

}
