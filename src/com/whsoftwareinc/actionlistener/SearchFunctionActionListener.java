/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.ui.NotesFrame;

public class SearchFunctionActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e)
	{
		/* Get the highlighter */
		Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
		/* Get the string the user is searching for */
		String searchWord = SearchMenuListener.searchBox.getText();
		/* Get the text from Notes' text area */
		String textAreaText = NotesFrame.textArea.getText();
		/* Get the offset of the searchword in the text area */
		int offset = textAreaText.indexOf(searchWord);
		/* Get the length of the search word for the highlighter */
		int length = searchWord.length();

		while (offset != -1)
		{
			try
			{
				Notes.highlighter.addHighlight(offset, offset + length, painter);
				offset = textAreaText.indexOf(searchWord, offset + 1);
			} catch (BadLocationException ex)
			{
				ex.printStackTrace();
			}

			/* If the word isn't found, break out of the loop */
			if (offset == -1)
				break;
		}
	}
}
