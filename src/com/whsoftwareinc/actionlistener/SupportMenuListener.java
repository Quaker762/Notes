/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;

public class SupportMenuListener implements ActionListener {
	public void actionPerformed(ActionEvent e)
	{
		/* Show a dialog box and get a yes/no response from the user */
		int response = JOptionPane.showConfirmDialog(Notes.frame, "WARNING! \n This will take you to a website in your default web browser! \n Would you like to continue?");

		if (response == JOptionPane.YES_OPTION)
		{
			URI weblink = URI.create("https://www.facebook.com/pages/Warehouse-Software/166916600062149");

			/* Try to open the link in the web browser */
			try
			{
				Desktop.getDesktop().browse(weblink);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		} else
		{
			return;
		}

	}

}
