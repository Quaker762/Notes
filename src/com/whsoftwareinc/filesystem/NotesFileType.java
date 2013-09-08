/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	V1 of the Notes File type (.ntf)
	
    //+---------------------------------------------------------------------------------------	
	//	How it works: 
	//	Each element of the document (.ntf, .docprop) are stored in a zip file renamed with
	//	a .ntf extension.
	//	When the file is loaded, the document property file is read first, and the variables
	//	set. After this occurs, the program reads the text portion and displays it to the screen.
	//	Even if a zip extension is renamed (in this case, to .ntf), the files in the zip are still
	//	readable
	//----------------------------------------------------------------------------------------

/--**/
package com.whsoftwareinc.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class NotesFileType {
	
	public NotesFileType()
	{
		
	}
	
	/*Read the file*/
	public void notesFileRead(File file) throws IOException
	{
		/*Declare file and zip input streams*/
		FileInputStream fis = new FileInputStream(file);
		ZipInputStream zis = new ZipInputStream(fis);
		ZipEntry ze;
		
		/*TODO: Read the propfile then read any file with a .ntf extension and load*/
		
		while((ze = zis.getNextEntry()) != null)
		{
			zis.closeEntry();
		}
		
		/*Close the Zip input*/
		zis.close();
		
	}
	
	/*Write the file*/
	public void notesFileWrite(File file) throws IOException
	{
		/*Set up variables*/
		FileInputStream fis = new FileInputStream(file);
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));
		String fn = file.getAbsolutePath();
		ZipEntry ze = new ZipEntry(fn);
		byte[] fbyte = new byte[(int)file.length()];
		
		/*Main functions*/
		fis.read(fbyte, 0, fbyte.length);
		ze.setSize((long)fbyte.length);
		zos.setLevel(1);
		zos.putNextEntry(ze);
		zos.write(fbyte, 0, fbyte.length);
		zos.finish();
		zos.close();
	}

}
