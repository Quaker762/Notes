/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class CountWordsActionListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0)
	{
		NotesTextBox text = NotesFrame.textArea;
		String wordCount = Integer.toString(text.getWordCount());
		WordCountMenuListener.wordCountField.setText(wordCount);
		text.getWordCount();
	}

}
