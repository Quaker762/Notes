/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	FEATURES:
	Read and load propfile on launch.
	
	TODO:
	Save and load propfile functions
	
	BUGS:
	Everything to do with lang here is VERY broken. Don't use it!

/--**/
package com.whsoftwareinc.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.whsoftwareinc.copyprotect.Keys;
import com.whsoftwareinc.Notes;

public class NotesPropFile {
	
	public Properties prop = new Properties();
	public Notes notes = new Notes();
	public String fileName = "notes.config";
	private NotesLangFile lang = new NotesLangFile();

	
	/*Create the propfile if it doesn't exist*/
	public void createPropFile()
	{
		File propfile = new File(fileName);
		
		try
		{
			if(!propfile.exists())
			{
				System.out.println("Property file not found. Now creating...");
				prop.setProperty("font", "Arial");
				prop.setProperty("serial", "");
				//prop.setProperty("lang", "english.lang");
				prop.setProperty("fontsize", "16");
				prop.setProperty("showlinenum", "false");
				prop.store(new FileOutputStream(fileName), null);
			}
			else
			{
				
			}
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*Read propfile when the program starts*/
	public void readPropFile()
	{
		String fileName = "notes.config";
		File propfile = new File(fileName);
		//File folder = new File("lang/");
		//File [] list = folder.listFiles();
		//NotesLangFile nlf = new NotesLangFile();
		
			try
			{
				prop.load(new FileInputStream(propfile));
				
		     	/*Scroll through all the files in the lang directory and match*/
			//	for(int i = 0; i < list.length; i++)
			//	{
			//		if(list[i].getName().equals(prop.getProperty("lang")))
			//		{
			//			//nlf.readLangFile(list[i]);
			//		}
			//	}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
	}
	
	/*Easier to read propfile val storer*/
	public void savePropToPropFile(String key, String value, String fileName)
	{
		prop.setProperty(key, value);
		
		try
		{
			prop.store(new FileOutputStream(fileName), null);
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/* Returns value of key */
	public String getProperty(String key)
	{
		return prop.getProperty(key);
	}

	public void setProperty(String key, String value)
	{
		prop.setProperty(key, value);
	}
}
