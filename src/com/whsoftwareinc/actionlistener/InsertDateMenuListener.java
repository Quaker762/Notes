package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class InsertDateMenuListener implements ActionListener {

	public void actionPerformed(ActionEvent arg0)
	{
		NotesTextBox text = NotesFrame.textArea;
		String Date = String.format("%tc", new Date(System.currentTimeMillis()));
		text.append(Date);
	}
}
