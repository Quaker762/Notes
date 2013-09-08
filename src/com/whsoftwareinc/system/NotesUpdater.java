/**++/
 *
 *	Copyright (c)  2013 WareHouse Software, Pty, Ltd
 *
 *	
 *	All Rights Reserved
 *                                                
/--**/
package com.whsoftwareinc.system;

import com.whsoftwareinc.Notes;

public class NotesUpdater {

	public NotesUpdater()
	{

	}

	public void checkUpdate()
	{
		/*TODO:
		 1.Check curVerNum
		 if(getCurVerNum < getVerNum)
		 	update the program
		 2.Apply the update
		 3.Copy the jar to the install dir
		 */
	}

	public double getVerNum()
	{
		/* TODO: Get version number from server? */
		return 0;
	}
	
	public String getCurVerNum()
	{
		return Notes.verNum;
	}

}
