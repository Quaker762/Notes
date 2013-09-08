/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.system.NotesFileOperations;

public class OpenMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) 
	{
		JFileChooser fileLoad = new JFileChooser();
		//TODO: Put the file filters here!
		fileLoad.showOpenDialog(Notes.frame);
		NotesFileOperations.openFile(fileLoad.getSelectedFile());
	}
}
