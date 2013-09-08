/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import com.whsoftwareinc.Notes;

public class SearchMenuListener implements ActionListener {

	public static JTextField searchBox = new JTextField(35);

	public void actionPerformed(ActionEvent e)
	{
		JDialog searchWindow = new JDialog(Notes.frame, "Search");

		JButton clear = new JButton("Clear");

		searchWindow.add(clear, BorderLayout.EAST);
		searchWindow.setVisible(true);
		searchWindow.setSize(200, 150);
		searchWindow.add(searchBox);
		searchWindow.pack();
		/* Add the ActionListeners */
		searchWindow.addWindowListener(new SearchMenuClosedActionListener());
		searchBox.addActionListener(new SearchFunctionActionListener());
	}

}
