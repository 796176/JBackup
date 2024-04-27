package GUI.AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConfigurationFrame extends Frame{
	public ConfigurationFrame() {
		setSize(GuiConstants.CONFIGURATION_FRAME_WIDTH, GuiConstants.CONFIGURATION_FRAME_HEIGHT);
		setResizable(false);
		setBackground(new Color(GuiColors.MAIN_WINDOW_BACKGROUND_COLOR));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

		Rectangle bounds = getGraphicsConfiguration().getBounds();
		setLocation(
			bounds.width / 2 - GuiConstants.CONFIGURATION_FRAME_WIDTH / 2,
			bounds.height / 2 - GuiConstants.CONFIGURATION_FRAME_HEIGHT / 2
		);

		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		GridBagConstraints panelConstraints = new GridBagConstraints();
		panelConstraints.weighty = 30;
		panelConstraints.weightx = 1;
		panelConstraints.fill = GridBagConstraints.BOTH;
		panelConstraints.insets = new Insets(
			GuiConstants.LIST_PANEL_OFFSET, GuiConstants.LIST_PANEL_OFFSET, 0, GuiConstants.LIST_PANEL_OFFSET
		);
		ChainList chainList = new ChainList();
		bagLayout.setConstraints(chainList, panelConstraints);
		add(chainList);

		GridBagConstraints addButtonConstrains = new GridBagConstraints();
		addButtonConstrains.weighty = 1;
		addButtonConstrains.weightx = 1;
		addButtonConstrains.gridy = 1;
		addButtonConstrains.anchor = GridBagConstraints.WEST;
		addButtonConstrains.insets = new Insets(
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			0
		);
		addButtonConstrains.ipadx = 20;
		Button addButton = new Button(GuiStrings.ADD_BUTTON);
		addButton.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		addButton.setBackground(new Color(GuiColors.ADD_BUTTON_COLOR));
		bagLayout.setConstraints(addButton, addButtonConstrains);
		add(addButton);

		GridBagConstraints scriptCheckBoxConstraints = new GridBagConstraints();
		scriptCheckBoxConstraints.weighty = 1;
		scriptCheckBoxConstraints.weightx = 1;
		scriptCheckBoxConstraints.gridy = 2;
		scriptCheckBoxConstraints.anchor = GridBagConstraints.WEST;
		scriptCheckBoxConstraints.insets = new Insets(
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			0
		);
		Checkbox scriptCheckBox = new Checkbox(GuiStrings.ENABLE_SCRIPT_CHECKBOX);
		scriptCheckBox.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		scriptCheckBox.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(scriptCheckBox, scriptCheckBoxConstraints);
		add(scriptCheckBox);

		GridBagConstraints scriptAreaConstraints = new GridBagConstraints();
		scriptAreaConstraints.weighty = 15;
		scriptAreaConstraints.weightx = 1;
		scriptAreaConstraints.gridy = 3;
		scriptAreaConstraints.fill = GridBagConstraints.BOTH;
		scriptAreaConstraints.insets = new Insets(
			0,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET,
			GuiConstants.DEFAULT_COMPONENT_OFFSET
		);
		TextArea scriptArea = new TextArea();
		scriptArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, GuiConstants.FONT_SIZE));
		scriptArea.setBackground(new Color(GuiColors.SCRIPT_AREA_COLOR));
		scriptArea.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(scriptArea, scriptAreaConstraints);
		add(scriptArea);
	}
}
