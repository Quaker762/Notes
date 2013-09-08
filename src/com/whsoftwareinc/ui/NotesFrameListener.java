package com.whsoftwareinc.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.ConsoleActionListener;

public class NotesFrameListener implements WindowListener {
	
	Notes notes = new Notes();

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

}
