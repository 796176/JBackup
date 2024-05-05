package GUI.AWT;

import controller.awt.Buttons;
import controller.awt.ChainDialogController;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class ChainDialog extends Dialog {
	public Choice choice;
	public Button sourceButton;
	public TextArea exceptions;
	public ChainDialog(Frame frame) {
		super(frame);
		setSize(GuiConstants.CHAIN_CONFIGURATION_WIDTH, GuiConstants.CHAIN_CONFIGURATION_HEIGHT);
		setResizable(false);
		setBackground(new Color(GuiColors.MAIN_WINDOW_BACKGROUND_COLOR));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ChainDialogController chainDialogController = new ChainDialogController((ChainDialog) e.getWindow());
				if (chainDialogController.addNewRule())
					setVisible(false);
			}
		});

		Rectangle bounds = getGraphicsConfiguration().getBounds();
		setLocation(
			bounds.width / 2 - GuiConstants.CHAIN_CONFIGURATION_WIDTH / 2,
			bounds.height / 2 - GuiConstants.CHAIN_CONFIGURATION_HEIGHT / 2
		);
		
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		GridBagConstraints leftElements = new GridBagConstraints();
		leftElements.weightx = 1;
		leftElements.weighty = 1;
		leftElements.anchor = GridBagConstraints.WEST;
		leftElements.insets = new Insets(
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING
		);

		choice = new Choice();
		choice.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		choice.setForeground(new Color(GuiColors.FONT_COLOR));
		choice.add(GuiStrings.FILE_DIRECTORY);
		bagLayout.setConstraints(choice, leftElements);
		add(choice);

		leftElements.gridy = 1;
		sourceButton = new Button(GuiStrings.FILE_DIRECTORY + ": " + GuiStrings.CHOOSE);
		sourceButton.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		sourceButton.setForeground(new Color(GuiColors.FONT_COLOR));
		sourceButton.addActionListener(actionEvent -> {
			var fileDialog = new FileDialog(this);
			fileDialog.setDirectory(System.getProperty("user.home"));
			fileDialog.setVisible(true);
			File[] files = fileDialog.getFiles();
			Buttons.assignDirectory(sourceButton, files);
		});
		bagLayout.setConstraints(sourceButton, leftElements);
		add(sourceButton);

		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.weightx = 1;
		labelConstraints.weighty = 1;
		labelConstraints.anchor = GridBagConstraints.NORTHWEST;
		Label label = new Label(GuiStrings.EXCEPTION_LABEL);
		label.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		label.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(label, labelConstraints);
		add(label);

		GridBagConstraints exceptionConstraints = new GridBagConstraints();
		exceptionConstraints.weighty = 30;
		exceptionConstraints.weightx = 1;
		exceptionConstraints.gridy = 1;
		exceptionConstraints.gridheight = 2;
		exceptionConstraints.fill = GridBagConstraints.BOTH;
		exceptions = new TextArea();
		exceptions.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		exceptions.setForeground(new Color(GuiColors.FONT_COLOR));
		exceptions.setBackground(new Color(GuiColors.MAIN_WINDOW_BACKGROUND_COLOR));
		bagLayout.setConstraints(exceptions, exceptionConstraints);
		add(exceptions);
	}
}
