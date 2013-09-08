/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	15/04/13 Added quitWith Exception() and getException()	Jesse
	16/04/13 getException now returns the error number toString()	Jesse
	
	USAGE:
	Call quitWithException(ex_num) when a quit may be required, such as an overflow or something may occur. 

/--**/
package com.whsoftwareinc.system;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole;

public class Watchdog {
	
	public Watchdog()
	{
	}
	
	/*Error codes*/
	public static final int STANDARD_QUIT = 0; //Program quit successfully.
	public static final int OUT_OF_MEMORY = -1; //Program used too much memory.
	public static final int FATAL_ERROR = -2; //General Fatal error. Probably wont be used.
	public static final int EXCESS_CPU_USAGE = -3; //Program used wayyy too much CPU.
	public static final int FILE_WRITE_ERROR = -4; //Program failed to write to a file.
	public static final int FILE_READ_ERROR = -5; //Program failed to read to a file. 
	
	public static final int TEST_CRASH_ERROR = -99; //Test Crash!
	
	/*Quits and prints to the console with the programs final, dying breath*/
	public static void quitWithException(int exception)
	{
		System.err.println("Notes has quit due to exception " + exception + ", " + getException(exception) + "!");
		Notes.console.dPrint(SystemConsole.Types.FATAL, "NOTES FATAL ERROR " + getException(exception));
		Notes.console.console.setForeground(Color.RED);
		Notes.console.forceVisible();
		fatalErrorBox(exception);
		dumpToLog();
		saveTempFile();
		storeSafeModeFile();
		System.exit(exception);
	}

	public static void quitWithException(int exception, String vars)
	{
		System.err.println("Notes has quit due to exception " + exception + ", " + getException(exception) + " " + vars + "!");
		Notes.console.dPrint(SystemConsole.Types.FATAL, "NOTES FATAL ERROR " + getException(exception) + vars);
		Notes.console.console.setForeground(Color.RED);
		Notes.console.forceVisible();
		fatalErrorBox(exception);
		dumpToLog();
		saveTempFile();
		storeSafeModeFile();
		System.exit(exception);
	}
	
	public static void fatalErrorBox(int exception)
	{
		JOptionPane.showMessageDialog(null,"Notes has run into an unexpected error and must close! \n" + "An error log has been written to the Notes directory\n "
				+ "A temporary file (temp.tmp) has also been written to the Notes Directory!\n" 
				+ getException(exception), null, JOptionPane.ERROR_MESSAGE, null);
	}
	
	/*Get the exception number and return the error*/
	public static String getException(int exception)
	{
		if(exception == -1)
		{
			System.err.println("Out of memory error!");
			return "OUT_OF_MEMORY";
		}
		else if(exception == -2)
		{
			System.err.println("Fatal Program error!");
			return "FATAL_ERROR";
		}
		else if(exception == -3)
		{
			System.err.println("Program using excess CPU!");
			return "EXCESS_CPU_USAGE";
		}
		else if(exception == -4)
		{
			System.err.println("Program failed to write to the file!");
			return "FILE_WRITE_ERROR";
		}
		else if(exception == -5)
		{
			System.err.println("Program failed to read the file!");
			return "FILE_READ_ERROR";
		}
		else if(exception == -99)
		{
			System.err.println("Program halted");
			return "TEST_ERROR!!";
		}
		else
		{
			System.err.println("Unknown error type");
			return "UNKNOWN_ERROR";
		}
	}
	
	/*Dump the console to an error log if we crash */
	public static void dumpToLog()
	{
		String filename = "errlog.txt";
		String date = String.format("%tc", new Date(System.currentTimeMillis()));
		try
		{
			PrintWriter writer = new PrintWriter(filename);
			writer.println("NOTES ERROR LOG \n");
			writer.println(date);
			writer.println(Notes.console.console.getText());
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/*Save the current document to a temp file for recovery later */
	public static void saveTempFile()
	{
		String allText = Notes.frame.textArea.getText();
		
		try
		{
			PrintWriter writer = new PrintWriter("temp.tmp");
			writer.println(allText);
			writer.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	/* Saves a file so Notes will start in safe Mode next time */
	private static void storeSafeModeFile()
	{
		File smode = new File("smode.err");
		try
		{
			smode.createNewFile();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
