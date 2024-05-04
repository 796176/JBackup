package GUI.AWT;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends Frame {
	public MainFrame(String title) {
		super(title);
		Dimension size = new Dimension(GuiConstants.MAIN_WINDOW_WIDTH, GuiConstants.MAIN_WINDOW_HEIGHT);
		setSize(size);
		setResizable(false);

		GraphicsConfiguration configuration = getGraphicsConfiguration();
		int xLocation = configuration.getBounds().width / 2 - GuiConstants.MAIN_WINDOW_WIDTH / 2;
		int yLocation = configuration.getBounds().height / 2 - GuiConstants.MAIN_WINDOW_HEIGHT / 2;
		setLocation(xLocation, yLocation);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setBackground(new Color(GuiColors.MAIN_WINDOW_BACKGROUND_COLOR));

		GridBagLayout bagLayout = new GridBagLayout();
		GridBagConstraints listPanelConstraints = new GridBagConstraints();
		setLayout(bagLayout);

		listPanelConstraints.fill = GridBagConstraints.BOTH;
		listPanelConstraints.weighty = 200;
		listPanelConstraints.gridx = 0;
		listPanelConstraints.gridy = 0;
		listPanelConstraints.weightx = 1;
		listPanelConstraints.insets = new Insets(
			GuiConstants.LIST_PANEL_OFFSET,
			GuiConstants.LIST_PANEL_OFFSET,
			0,
			GuiConstants.LIST_PANEL_OFFSET
		);

		MainList list = new MainList();
		bagLayout.setConstraints(list, listPanelConstraints);
		add(list);

		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridy = 1;
		buttonConstraints.anchor = GridBagConstraints.WEST;
		buttonConstraints.gridx = 0;
		buttonConstraints.ipadx = 50;
		buttonConstraints.insets = new Insets(
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.LIST_PANEL_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			0
		);
		Button addButton = new Button(GuiStrings.ADD_BUTTON);
		addButton.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		addButton.setBackground(new Color(GuiColors.ADD_BUTTON_COLOR));
		addButton.addActionListener(actionEvent -> {
			var configurationFrame = new ConfigurationFrame();
			configurationFrame.setVisible(true);
		});
		bagLayout.setConstraints(addButton, buttonConstraints);
		add(addButton);

		GridBagConstraints mainTextAreaConstraints = new GridBagConstraints();
		mainTextAreaConstraints.gridy = 2;
		mainTextAreaConstraints.gridx = 0;
		mainTextAreaConstraints.weighty = 2;
		mainTextAreaConstraints.weightx = 1;
		TextArea textArea = new TextArea(GuiConstants.MAIN_TEXT_AREA_VISIBLE_ROWS, 1);
		textArea.setBackground(new Color(GuiColors.MAIN_TEXT_FIELD_COLOR));
		textArea.setEditable(false);
		textArea.setForeground(new Color(GuiColors.FONT_COLOR));
		textArea.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		mainTextAreaConstraints.fill = GridBagConstraints.BOTH;
		bagLayout.setConstraints(textArea, mainTextAreaConstraints);
		add(textArea);

		setVisible(true);
	}
}
