package GUI.AWT;

import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

public class MainList extends Panel {
	public MainList(){
		setBackground(new Color(GuiColors.LIST_PANEL_COLOR));

		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		ListItem[] items = new ListItem[] {
			new ListItem("name", 4, true, DateFormat.getDateInstance().format(new Date())),
			new ListItem("name 2", 2, false, DateFormat.getTimeInstance().format(new Date())),
			new ListItem("name 3", 12, false, DateFormat.getTimeInstance().format(new Date()))
		};
		GridBagConstraints itemConstraints = new GridBagConstraints();
		itemConstraints.insets = new Insets(
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING
		);
		itemConstraints.fill = GridBagConstraints.BOTH;
		itemConstraints.gridheight = 2;
		itemConstraints.weightx = 70;
		itemConstraints.weighty = 1;

		for (int i = 0; i < 3; i++) {
			itemConstraints.gridy = i * 2;
			bagLayout.setConstraints(items[i], itemConstraints);
			add(items[i]);
		}

		GridBagConstraints sidePanelConstraints = new GridBagConstraints();
		sidePanelConstraints.weighty = 1;
		sidePanelConstraints.weightx = 1;
		sidePanelConstraints.gridx = 1;
		sidePanelConstraints.gridheight = 7;
		sidePanelConstraints.fill = GridBagConstraints.BOTH;
		sidePanelConstraints.insets = new Insets(
			GuiConstants.INNER_COMPONENT_SPACING, 0, GuiConstants.INNER_COMPONENT_SPACING, 0
		);

		Panel sidePanel = new Panel();
		sidePanel.setBackground(new Color(GuiColors.LIST_PANEL_COLOR));
		sidePanel.setLayout(new GridLayout(0, 1));
		bagLayout.setConstraints(sidePanel, sidePanelConstraints);
		add(sidePanel);

		Button upButton = new Button("^");
		upButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, GuiConstants.FONT_SIZE));
		upButton.setForeground(new Color(GuiColors.FONT_COLOR));
		sidePanel.add(upButton);

		Button downButton = new Button("v");
		downButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, GuiConstants.FONT_SIZE));
		downButton.setForeground(new Color(GuiColors.FONT_COLOR));
		sidePanel.add(downButton);
	}
}
