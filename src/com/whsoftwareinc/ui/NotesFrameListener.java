package com.whsoftwareinc.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.ConsoleActionListener;
import com.whsoftwareinc.system.NotesFileOperations;

public class NotesFrameListener implements WindowListener {
	
	Notes notes = new Notes();
	NotesTextBox textArea = NotesFrame.textArea;

	public void windowActivated(WindowEvent arg0)
	{

	}

	public void windowClosed(WindowEvent arg0)
	{
		
	}

	public void windowClosing(WindowEvent arg0)
	{
		if(notes.debugmode)
		{
			ConsoleActionListener.dumpToLog();
		}
		else
		{
			if(NotesTextBox.isSaved == false)
			{
				clear();
			}
			else
			{
				System.exit(0);
			}
			
			System.out.println("Notes has been quit!!!");
		}
	}

	public void windowDeactivated(WindowEvent arg0)
	{
	}

	public void windowDeiconified(WindowEvent arg0)
	{

	}

	public void windowIconified(WindowEvent arg0)
	{

	}

	public void windowOpened(WindowEvent arg0)
	{

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
