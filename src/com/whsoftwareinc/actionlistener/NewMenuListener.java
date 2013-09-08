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
import com.whsoftwareinc.system.NotesLangFile;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;


public class NewMenuListener implements ActionListener {
	
	NotesTextBox textArea = NotesFrame.textArea;

	public void actionPerformed(ActionEvent e) 
	{
		if(textArea.isSaved == true)
			textArea.setText("");
		else
			checkClear();
		
		//TODO: Check if the frame is tabbed..
		//NotesFrame.tabs.createNewTextTab();
		//NotesFrame.tabs.setSelectedIndex(NotesFrame.tabs.id - 2);
		//Index: 2, Tab count: 2 Okkkayyyy Lets just subtract 2 to prevent this...
	}
	
	
	public static String getConfirm()
	{
		return NotesLangFile.confirm;
	}
	
	public void checkClear()
	{
		//int response = JOptionPane.showConfirmDialog(Notes.frame, "Would you like to save first?");
		int response = JOptionPane.showConfirmDialog(Notes.frame, getConfirm());
		if(response == JOptionPane.YES_OPTION)
		{
			textArea.getText();
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(Notes.frame);
			NotesFileOperations.saveFile(fileSave.getSelectedFile());
			textArea.isSaved = true;
		}
		else if(response == JOptionPane.NO_OPTION)
		{
			textArea.isSaved = false;
			textArea.setText("");
			textArea.requestFocus();
		}
		else
		{
			return;
		}
	}
}
