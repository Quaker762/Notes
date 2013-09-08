/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.copyprotect;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;

public class CheckKey {
	
	public CheckKey()
	{
		
	}
	
	public ImageIcon icon = new ImageIcon(CheckKey.class.getResource("/checkkey.png"));
	
	/*Main copy protect method*/
	public void checkKey()
	{
		Notes notes = new Notes();
		boolean checked;
  		
		String serial = (String)JOptionPane.showInputDialog(null, "Enter Serial Key", "CheckKey v0.1", JOptionPane.INFORMATION_MESSAGE, icon, null, null);
		
		/*Scroll through all keys*/
		for(int i = 0; i < Keys.serials.length; i++)
		{
			if(serial.equals(Keys.serials[i]))
			{		
				/*Tell the system that we passed the keycheck*/
				checked = true;
				System.out.println("Pass!");
				Notes.npropfile.savePropToPropFile("serial", serial, Notes.npropfile.fileName);
			}
			else
			{
				checked = false;
			}
			
			if(checked)
			{
				/*Store key to the propfile*/
				
				/*Initialise Notes*/
				notes.initSystem();
			}
		}
	}
}
