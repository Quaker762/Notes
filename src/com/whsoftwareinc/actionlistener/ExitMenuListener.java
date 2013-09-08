/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/

package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.system.NotesFileOperations;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class ExitMenuListener implements ActionListener {
	
	NotesTextBox textArea = NotesFrame.textArea;

	public void actionPerformed(ActionEvent e) 
	{
		if(NotesTextBox.isSaved == false)
		{
			clear();
		}
		else
		{
			System.exit(0);
		}
	}
	
	public void clear()
	{
		int response = JOptionPane.showConfirmDialog(Notes.frame, "Would you like to save first?");
		if(response == JOptionPane.YES_OPTION)
		{
			textArea.getText();
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(Notes.frame);
			NotesFileOperations.saveFile(fileSave.getSelectedFile());
			System.exit(0);
		}
		else if(response == JOptionPane.NO_OPTION)
		{
			System.exit(0);
		}
		else if(response == JOptionPane.CANCEL_OPTION)
		{
			/*GET ME OUTTA HERE!!!*/
			return;
		}
	}
}
