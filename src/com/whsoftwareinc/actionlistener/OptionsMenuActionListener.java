/**++/
*
*	Copyright (c)  2013 WareHouse Software, Pty, Ltd
*
*	
*	All Rights Reserved
*                                                
/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.ui.NotesTabbedPane;

public class OptionsMenuActionListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0)
	{
		JDialog optionsDialog = new JDialog(Notes.frame, "Settings");
		NotesTabbedPane tabs = new NotesTabbedPane();
		optionsDialog.setSize(550, 250);
		optionsDialog.setVisible(true);
		optionsDialog.add(tabs);
		
		tabs.addTab("Tab1", null);
		tabs.addTab("Tab2", null);
	}
}
