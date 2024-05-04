package controller.awt;

import GUI.AWT.ChainDialog;
import GUI.AWT.GuiStrings;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Iterator;

public class ChainDialogController {
	ChainDialog chainDialog;
	public ChainDialogController(ChainDialog chainDialog){
		this.chainDialog = chainDialog;
	}

	public boolean addNewRule(){
		Dialog dialog = new Dialog(chainDialog);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
			}
		});
		dialog.setSize(2000, 0);

		File sourceFile = new File(chainDialog.sourceButton.getLabel());
		if (!sourceFile.exists()) {
			dialog.setTitle("\"" + chainDialog.sourceButton.getLabel() + "\" " + GuiStrings.FILE_DOES_NOT_EXIST);
			dialog.setVisible(true);
			return false;
		}

		Iterator<String> exceptions = chainDialog.exceptions.getText().lines().iterator();
		while (exceptions.hasNext()) {
			String exception = exceptions.next();
			File fileException = new File(exception);
			if (!fileException.exists()) {
				dialog.setTitle("\"" + exception + "\" " + GuiStrings.FILE_DOES_NOT_EXIST);
				dialog.setVisible(true);
				return false;
			}
		}

		return true;
	}
}
