package GUI.AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RemoveDialog extends Dialog {
	public RemoveDialog(Frame frame) {
		super(frame);

		setBackground(new Color(GuiColors.MAIN_WINDOW_BACKGROUND_COLOR));
		setSize(GuiConstants.CONFIRMATION_DIALOG_WIDTH, GuiConstants.CONFIRMATION_DIALOG_HEIGHT);
		setResizable(false);
		setTitle(GuiStrings.CONFIRMATION_DIALOG_TITLE);
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);


		Rectangle bounds = getGraphicsConfiguration().getBounds();
		setLocation(
			bounds.width / 2 - GuiConstants.CONFIRMATION_DIALOG_WIDTH / 2,
			bounds.height / 2 - GuiConstants.CONFIRMATION_DIALOG_HEIGHT / 2
		);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.ipady = 60;
		constraints.ipadx = 100;
		Button delete = new Button(GuiStrings.DELETE_BUTTON);
		delete.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		delete.setBackground(new Color(GuiColors.DELETE_BUTTON_COLOR));
		bagLayout.setConstraints(delete, constraints);
		add(delete);

		Button cancel = new Button(GuiStrings.CANCEL_BUTTON);
		cancel.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		cancel.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(cancel, constraints);
		add(cancel);
	}
}
