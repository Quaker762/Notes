/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.ui;

import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.JTextArea;
import javax.swing.text.Highlighter;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.actionlistener.WordCountMenuListener;

public class NotesTextBox extends JTextArea {

	int width;
	int height;
	String text;
	int wordCount;
	int charAmount;
	int id;
	/* Returns whether or not the progrma has saved the current document */
	public static boolean isSaved = false;

	public NotesTextBox()
	{
		this.setLineWrap(true);
		this.requestFocus();
	}
	
	public NotesTextBox(int id)
	{
		this.setLineWrap(true);
		this.requestFocus();
		this.id = id;
	}

	public NotesTextBox(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.getDocument().addDocumentListener(new NotesDocumentListener());
		this.requestFocus();
	}

	// Get the amount of words in the Text Area.
	public int getWordCount()
	{
		wordCount = 0;
		String text = this.getText();
		StringTokenizer strt = new StringTokenizer(text, " ");
		while (strt.hasMoreElements())
		{
			String token = strt.nextToken();
			wordCount++;
		}
		return wordCount;
	}
	// Get the character amount in the Text Area.
	
	//Return the ID of the textbox
	public int getID()
	{
		return NotesFrame.tabs.id;
	}
	
	public NotesTextBox getID(int id)
	{
		this.id = getID();
		return this;
	}
}
