/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.whsoftwareinc.Notes;

public class SearchMenuClosedActionListener implements WindowListener {

	public void windowActivated(WindowEvent arg0)
	{

	}

	public void windowClosed(WindowEvent arg0)
	{
		
	}

	public void windowClosing(WindowEvent arg0)
	{
		Notes.highlighter.removeAllHighlights();
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
