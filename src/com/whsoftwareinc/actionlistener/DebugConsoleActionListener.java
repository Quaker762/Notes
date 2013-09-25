/**++/

 Copyright (c)  2013 WareHouse Software, Pty, Ltd

 Notes Remake 2013
 Code a LOT cleaner than the original. The original architecture and functionality
 of the program will be exactly the same, and it should be much easier to implements
 features due to this. Much easier to read ^_^

 12/04/13 First bring up version	Jesse
 12/04/13 Added plugin functionality	Jesse

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole;

public class DebugConsoleActionListener implements ActionListener {
	
	public SystemConsole console = new SystemConsole();
	
	public void actionPerformed(ActionEvent arg0)
	{
		console.consoleFrame.setVisible(true);
		console.consoleFrame.setLocationRelativeTo(Notes.frame);
		console.input.requestFocus();
	}

}
