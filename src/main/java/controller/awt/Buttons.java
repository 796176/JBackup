package controller.awt;

import GUI.AWT.GuiConstants;

import java.awt.*;
import java.io.File;

public class Buttons {
	public static void assignDirectory(Button b, File[] files) {
		b.setFont(new Font(b.getFont().getFontName(), b.getFont().getStyle(), GuiConstants.FONT_SIZE_SMALL));
		b.setLabel(files[0].getAbsolutePath());
	}
}
