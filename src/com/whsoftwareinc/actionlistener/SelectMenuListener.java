/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class SelectMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) 
	{
		NotesTextBox text = NotesFrame.textArea;
		text.selectAll();
	}

}
