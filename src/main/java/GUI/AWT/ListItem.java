package GUI.AWT;

import java.awt.*;

public class ListItem extends Panel {
	Label name;
	Label subtitle;
	Label lastExecuted;
	Button deleteButton;
	Button runButton;

	public ListItem(String name, int chainNumber, boolean bashScript, String date) {
		setBackground(new Color(GuiColors.LIST_ITEM_COLOR));

		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.anchor = GridBagConstraints.NORTHWEST;
		labelConstraints.weightx = 1;
		labelConstraints.weighty = 1;

		this.name = new Label(name);
		this.name.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		this.name.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(this.name, labelConstraints);
		add(this.name);

		StringBuilder subtitle = new StringBuilder(chainNumber + GuiStrings.SUBTITLE_LABEL[0]);
		if (bashScript) subtitle.append(GuiStrings.SUBTITLE_LABEL[1]);
		this.subtitle = new Label(subtitle.toString());
		this.subtitle.setForeground(new Color(GuiColors.FONT_COLOR));
		labelConstraints.gridy = 1;
		bagLayout.setConstraints(this.subtitle, labelConstraints);
		add(this.subtitle);

		labelConstraints.gridy = 2;
		lastExecuted = new Label(GuiStrings.LAST_EXECUTION_LABEL + " " + date);
		lastExecuted.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(lastExecuted, labelConstraints);
		add(lastExecuted);

		GridBagConstraints buttonConstraints = new GridBagConstraints();
		buttonConstraints.gridy = 3;
		buttonConstraints.anchor = GridBagConstraints.SOUTHWEST;
		buttonConstraints.weightx = 1;
		buttonConstraints.weighty = 10;
		buttonConstraints.ipadx = 80;
		buttonConstraints.ipady = 30;
		buttonConstraints.insets = new Insets(
			0,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING
		);

		runButton = new Button(GuiStrings.RUN_BUTTON);
		runButton.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		runButton.setBackground(new Color(GuiColors.RUN_BUTTON_COLOR));
		bagLayout.setConstraints(runButton, buttonConstraints);
		add(runButton);

		buttonConstraints.gridx = 1;
		buttonConstraints.anchor = GridBagConstraints.SOUTHEAST;
		deleteButton = new Button(GuiStrings.DELETE_BUTTON);
		deleteButton.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		deleteButton.setBackground(new Color(GuiColors.DELETE_BUTTON_COLOR));
		bagLayout.setConstraints(deleteButton, buttonConstraints);
		add(deleteButton);
	}
}
