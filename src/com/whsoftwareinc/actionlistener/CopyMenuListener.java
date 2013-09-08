/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.ui.NotesFrame;

public class CopyMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) 
	{
		String selected = NotesFrame.textArea.getSelectedText();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection clipString = new StringSelection(selected);
		clipboard.setContents(clipString, clipString);
	}
}
