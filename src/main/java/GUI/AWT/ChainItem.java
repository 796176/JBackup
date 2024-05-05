package GUI.AWT;

import java.awt.*;

public class ChainItem extends Panel {
	Label type;
	Label from;
	Button remove;
	public ChainItem(String type, String source) {
		setBackground(new Color(GuiColors.LIST_ITEM_COLOR));
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		GridBagConstraints labelConstraints = new GridBagConstraints();
		labelConstraints.weightx = 1;
		labelConstraints.weighty = 1;
		labelConstraints.anchor = GridBagConstraints.WEST;

		this.type = new Label(type);
		this.type.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		this.type.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(this.type, labelConstraints);
		add(this.type);

		labelConstraints.gridy = 1;
		from = new Label(source);
		from.setFont(new Font(Font.SERIF, Font.PLAIN, GuiConstants.FONT_SIZE));
		from.setForeground(new Color(GuiColors.FONT_COLOR));
		bagLayout.setConstraints(from, labelConstraints);
		add(from);

		GridBagConstraints removeButtonConstraints = new GridBagConstraints();
		removeButtonConstraints.gridx = 1;
		removeButtonConstraints.gridheight = 2;
		removeButtonConstraints.anchor = GridBagConstraints.SOUTHEAST;
		remove = new Button("-");
		remove.setBackground(new Color(GuiColors.DELETE_BUTTON_COLOR));
		remove.setFont(new Font(Font.MONOSPACED, Font.PLAIN, GuiConstants.FONT_SIZE));
		bagLayout.setConstraints(remove, removeButtonConstraints);
		add(remove);
	}
}
