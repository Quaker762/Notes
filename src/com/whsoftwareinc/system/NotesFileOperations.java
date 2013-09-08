/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	Static for now so they can be accessed from anywhere.

/--**/
package com.whsoftwareinc.system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class NotesFileOperations {
	
	static NotesTextBox txtbox = NotesFrame.textArea;
	
	public static void openFile(File file)
	{
		String name = file.getName();
		String line;
		int extension = name.lastIndexOf(".");
		String ext = name.substring(extension + 1);	
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
				txtbox.setText(sb.toString());
			}
			Notes.frame.setTitle(file.getName());
		}
		catch(IOException ex)
		{
			System.out.println("Couldn't open file.");
			ex.printStackTrace();
		}
			
		if(ext.equals("doc") || ext.equals("docx"))
		{
			//TODO: Try to open Doc file here. Think they're just XML documents
			Notes.console.dPrint(SystemConsole.Types.SYSTEM, "Attempting to open Microsoft Doc File...");
		}	
	}
	
	public static void saveFile(File file)
	{
		NotesTextBox.isSaved = true;
		
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".ntf"));
			writer.write(txtbox.getText() + "" + "");
			writer.close();
		}
		catch(IOException ex)
		{
			System.out.println("Couldn't write file!");
			ex.printStackTrace();
		}
	}
}
