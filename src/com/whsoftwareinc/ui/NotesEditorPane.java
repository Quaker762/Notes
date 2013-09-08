/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/

package com.whsoftwareinc.ui;

import java.util.StringTokenizer;

import javax.swing.JEditorPane;

public class NotesEditorPane extends JEditorPane {
	
	int width;
	int height;
	String text;
	int wordCount;
	int charAmount;
	
	public NotesEditorPane()
	{

	}
	
	public NotesEditorPane(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.setSize(width, height);
	}
	
	/*Get the amount of words in the Text Area.*/
	public int getWordCount()
	{
		String text = this.getText();
		StringTokenizer strt = new StringTokenizer(text, " ");
		while(strt.hasMoreElements())
		{
			String token = strt.nextToken();
			wordCount++;
		}
		
		return wordCount;
	}
	
	/*Get the character amount in the Text Area.*/
	public int getLength()
	{
		charAmount = text.length();
		
		return charAmount;	
	}
}
