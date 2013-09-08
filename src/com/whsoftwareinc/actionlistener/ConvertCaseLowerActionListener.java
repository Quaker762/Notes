package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import com.whsoftwareinc.ui.NotesFrame;

public class ConvertCaseLowerActionListener implements ActionListener {

	public String text;
	
	public void actionPerformed(ActionEvent arg0)
	{
		//Get all the text in the text area
		text = NotesFrame.textArea.getText().toLowerCase(Locale.UK);
		//Set the text to nothing
		NotesFrame.textArea.setText("");
		//Now replace the text with the converted, selected text
		NotesFrame.textArea.setText(text);
	}
}
