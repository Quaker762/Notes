package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.system.Watchdog;
import com.whsoftwareinc.system.Updater;

public class UpdateActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent arg0)
	{
		try
		{
			if(Float.parseFloat(Updater.getLatestVersion()) > Float.parseFloat(Notes.verNum))
			{
				int response = JOptionPane.showConfirmDialog(Notes.frame, "There is an update available!\nWould you like to update?\nPatch Notes: " + Updater.getUpdates());
				
				if(response == JOptionPane.YES_OPTION)
				{
					String[] run = {"java", "-jar", "update.jar"};
					try
					{
						Runtime.getRuntime().exec(run);
						System.out.println("TO THE UPDATER!");
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						Watchdog.quitWithException(-2);
					}
					System.exit(0);
				}
				else if(response == JOptionPane.NO_OPTION)
				{
					return;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(Notes.frame, "Notes is up to date!", "Update", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
