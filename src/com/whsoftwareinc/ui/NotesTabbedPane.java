/**++/
*
*	Copyright (c)  2013 WareHouse Software, Pty, Ltd
*
*	
*	All Rights Reserved
*                                                
/--**/
package com.whsoftwareinc.ui;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole.Types;

public class NotesTabbedPane extends JTabbedPane {
	
	NotesFrame frame = Notes.frame;
	
	private boolean dragging = false;
	public int id = 1;
	private ImageIcon icon = new ImageIcon("res/button/page.png");
	
	
	public NotesTabbedPane()
	{
		
	}
	
	public void renderPane()
	{
		
	}
	
	public void createNewTab()
	{
		
	}
	
	public void createNewTextTab()
	{
		NotesTextBox text = new NotesTextBox();
		JScrollPane scrollBar = new JScrollPane(new NotesTextBox());
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		NotesFrame.tabs.addTab("New " + Integer.toString(id), icon, scrollBar);
		id+=1;
		Notes.console.dPrint(Types.SYSTEM, "Opened a new tab," + id + " With textbox id," + text.getID());
	}
	
	//Return the ID of the currently open tab
	public int getTabID()
	{
		return this.id;
	}
	
	public NotesTabbedPane getID(int id)
	{
		this.id = getTabID();
		return this;
	}
	
	
}
