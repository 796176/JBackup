package GUI.AWT;

import java.awt.*;

public class ChainList extends Panel {
	public ChainList() {
		setBackground(new Color(GuiColors.LIST_PANEL_COLOR));
		GridBagLayout bagLayout = new GridBagLayout();
		setLayout(bagLayout);

		ChainItem[] chains = new ChainItem[]{
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination"),
			new ChainItem("type", "source", "destination")
		};

		GridBagConstraints chainConstraints = new GridBagConstraints();
		chainConstraints.weighty = 1;
		chainConstraints.weightx = 90;
		chainConstraints.fill = GridBagConstraints.BOTH;
		chainConstraints.gridy = 0;
		chainConstraints.insets = new Insets(
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING
		);

		for (ChainItem chain : chains) {
			bagLayout.setConstraints(chain, chainConstraints);
			add(chain);
			chainConstraints.gridy++;
		}

		GridBagConstraints sidePanelConstraints = new GridBagConstraints();
		sidePanelConstraints.weighty = 1;
		sidePanelConstraints.weightx = 1;
		sidePanelConstraints.fill = GridBagConstraints.BOTH;
		sidePanelConstraints.gridx = 1;
		sidePanelConstraints.gridheight = 7;
		sidePanelConstraints.insets = new Insets(
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING,
			GuiConstants.INNER_COMPONENT_SPACING
		);
		Panel sidePanel = new Panel();
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
