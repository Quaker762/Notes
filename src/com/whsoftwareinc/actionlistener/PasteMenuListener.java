/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class PasteMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e) 
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable clipTrans = clipboard.getContents(NotesTextBox.class);
		
		try 
		{
			String sel = (String)clipTrans.getTransferData(DataFlavor.stringFlavor);
			NotesFrame.textArea.replaceRange(sel, NotesFrame.textArea.getSelectionStart(), NotesFrame.textArea.getSelectionEnd());
		} 
		catch (UnsupportedFlavorException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}

}
