/**++/
*
*	Copyright (c)  2013 WareHouse Software, Pty, Ltd
*
*	
*	All Rights Reserved
*                                                
/--**/
package com.whsoftwareinc.debug;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.whsoftwareinc.Notes;

public class ConsoleKeyListener implements KeyListener {
	
	//Times the key has been pusshed
	int tPushed = 0;
	int size;

	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		if(keycode == KeyEvent.VK_UP)
		{
			size = ConsoleActionListener.lastComm.size();
			SystemConsole.input.setText(ConsoleActionListener.lastComm.get(size - 1 - tPushed));
			tPushed++;
		}	
		
		//Set the boundaries of tPushed
		if(tPushed <= 0 || tPushed >= size)
		{
			tPushed = 0;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		//tPushed = tPushed; Pointless...
	}

	public void keyTyped(KeyEvent e)
	{
		
	}
	
	public int getTimesPressed()
	{
		return tPushed;
	}
}
