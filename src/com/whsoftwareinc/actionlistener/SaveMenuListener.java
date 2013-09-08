/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.system.NotesFileOperations;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class SaveMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) 
	{
		NotesTextBox txtbox = NotesFrame.textArea;
		JFileChooser fileSave = new JFileChooser();
		fileSave.showSaveDialog(Notes.frame);
		NotesFileOperations.saveFile(fileSave.getSelectedFile());
	}
}
