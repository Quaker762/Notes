/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/

package com.whsoftwareinc.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NotesDocumentListener implements DocumentListener {

	public void changedUpdate(DocumentEvent ex) 
	{
		
	}

	public void insertUpdate(DocumentEvent ex) 
	{
		NotesTextBox.isSaved = false;
	}

	public void removeUpdate(DocumentEvent ex) 
	{
		NotesTextBox.isSaved = false;
	}
}
