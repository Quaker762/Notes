/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import com.whsoftwareinc.Notes;

public class WordCountMenuListener implements ActionListener {
	
	public static JTextField wordCountField = new JTextField(50);
	public static JTextField charCountField = new JTextField(50);
	
	public void actionPerformed(ActionEvent e)
	{
		/* Most variables aren't used anywhere else, so we can put them here */
		JButton wordCountButton = new JButton("Recount");
		JButton charCountButton = new JButton("Recount");
		JTabbedPane tabs = new JTabbedPane();
		JDialog wordCountDialog = new JDialog(Notes.frame, "Word Count");
		JPanel wordCountPanel = new JPanel();
		JPanel charCountPanel = new JPanel();
		
		/*All the UI stuff */
		wordCountDialog.add(tabs);
		tabs.addTab("Word Count", wordCountPanel);
		tabs.addTab("Character Count", charCountPanel);
		wordCountPanel.setLayout(new BoxLayout(wordCountPanel, BoxLayout.X_AXIS));
		charCountPanel.setLayout(new BoxLayout(charCountPanel, BoxLayout.X_AXIS));
		wordCountPanel.add(wordCountField);
		charCountPanel.add(charCountField);
		wordCountPanel.add(wordCountButton);
		charCountPanel.add(charCountButton);
		wordCountButton.addActionListener(new CountWordsActionListener());
		charCountButton.addActionListener(new CountCharactersActionListener());
		wordCountField.setText("< Click To Recount >");
		charCountField.setText("< Click To Recount >");
		wordCountDialog.pack();
		wordCountDialog.setSize(350, 90);
		wordCountDialog.setVisible(true);
	}

}
