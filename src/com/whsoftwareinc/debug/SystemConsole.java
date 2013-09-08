/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.debug;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.whsoftwareinc.Notes;

public class SystemConsole {

	/* Console UI elements */
	public JDialog consoleFrame;
	public static JTextArea console;
	public static JTextField input;
	public JScrollPane pane;

	/* Constructor */
	public SystemConsole()
	{
		consoleFrame = new JDialog(Notes.frame);
		console = new JTextArea();
		input = new JTextField(consoleFrame.getWidth());
		pane = new JScrollPane(console);
		console.setBackground(Color.BLACK);
		console.setForeground(Color.GREEN);
		console.setFont(new Font("Courier New", 12, 12));
		console.setEditable(false);

		consoleFrame.add(pane);
		consoleFrame.add(input, BorderLayout.SOUTH);
		//consoleFrame.setSize(300, 450);
		consoleFrame.setSize(1000, 450);
		consoleFrame.setTitle("Notes System Console");
		consoleFrame.setLocationRelativeTo(Notes.frame);
		//console.setEditable(false);
		input.addActionListener(new ConsoleActionListener());
		input.addKeyListener(new ConsoleKeyListener());
		dPrint(Types.SYSTEM, "Console intialised successfully!");
	}

	/* Print the console message to the system and in program console */
	public void dPrint(String string)
	{
		System.out.println(string);
		console.append(string + "\n");
	}
	
	public void dPrint(Types type, String string)
	{
		System.out.println(string);
		console.append(type + ": " + string + "\n");
	}
	
	public String getText()
	{
		return console.getText();
	}
	
	public String getInputText()
	{
		return input.getText();
	}
	
	public void clearInput()
	{
		input.setText("");
	}
	
	public void forceVisible()
	{
		console.setVisible(true);
	}
	
	public static enum Types
	{
		SYSTEM, WARNING, ERROR, FATAL
	}
}
