/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.debug;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole.Types;
import com.whsoftwareinc.exception.UnknownLanguageException;
import com.whsoftwareinc.system.Watchdog;
import com.whsoftwareinc.system.NotesLangFile;
import com.whsoftwareinc.system.OSMemoryInfo;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class ConsoleActionListener implements ActionListener {
	
	public CPUMonitor cpu = new CPUMonitor();
	public boolean isCpuDebug = false;
	public boolean debugMode = true;
	
	public static ArrayList<String> lastComm = new ArrayList<String>();
	
	public OSMemoryInfo meminf = new OSMemoryInfo();
	
	public void actionPerformed(ActionEvent arg0)
	{
		String command = Notes.console.getInputText();
		parseCommand(command);
		lastComm.add(command);
	}
	
	/* Parses a command from the console to the system */
	public void parseCommand(String command)
	{
		if(command.startsWith("/"))
		{
			String comm = command.toLowerCase().replaceFirst("/", "");
			Notes.console.clearInput();
			if(comm.startsWith("exit"))
			{
				Notes.console.clearInput();
				Notes.console.dPrint(SystemConsole.Types.SYSTEM, "Notes now exiting!");
				Notes.exit();
			}
			else if(comm.startsWith("plugins"))
			{
				Notes.console.dPrint("Current Plugins loaded: ");
				File dir = new File("plugs/");
				String[] plugins = dir.list();
				for(int i = 0; i < plugins.length; i++)
				{
					Notes.console.dPrint(plugins[i]);
				}
			}
			else if(comm.startsWith("dumplog"))
			{
				dumpToLog();
			}
			else if(comm.startsWith("dummy"))
			{
				dummyCommand(command.substring(7));
			}
			else if(comm.startsWith("date"))
			{
				String date = String.format("%tc", new Date(System.currentTimeMillis()));
				Notes.console.dPrint("The date is " + date);
			}
			else if(comm.startsWith("sysinfo"))
			{
				Notes.console.dPrint("Max Memory JVM will use(MB): " + meminf.maxMem / OSMemoryInfo.MEGABYTE);
				Notes.console.dPrint("Total Memory JVM can use(MB): " + meminf.totalMem / OSMemoryInfo.MEGABYTE);
				Notes.console.dPrint("# CPU cores in system: " + meminf.cpus);
				Notes.console.dPrint("Amount of free memory(MB): " + meminf.freeMem / OSMemoryInfo.MEGABYTE);
			}
			else if(comm.startsWith("forceupdate"))
			{
				Notes.console.dPrint(SystemConsole.Types.SYSTEM, "Forcing update...");
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
			else if(comm.startsWith("verinfo"))
			{
				Notes.console.dPrint("Notes by WareHouse Software");
				Notes.console.dPrint("Currently Running " + Notes.getVersion());
				Notes.console.dPrint("Note that this is Beta Software! It does not represent the final or finished product!");
			}
			else if(comm.startsWith("crash"))
			{
				crash(Integer.parseInt(command.substring(7)));
			}
			else if(comm.startsWith("restart"))
			{
				String[] run = {"java", "-jar", "Notes.jar"};
				try
				{
					Notes.console.dPrint(Types.WARNING, "RESTARTING NOTES...");
					Runtime.getRuntime().exec(run);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);
			}
			else if(comm.startsWith("switchlang"))
			{
				switchLang(command.substring(12));
			}
			else if(comm.startsWith("createtab"))
			{
				NotesFrame.tabs.createNewTextTab();
			}
			else if(comm.startsWith("changethemewin"))
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else if(comm.startsWith("changethemejava"))
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			else if(comm.startsWith("rungc"))
			{
				System.gc();
				Notes.console.dPrint(Types.SYSTEM, "Garbage Collection Run!");
			}
			else if(comm.startsWith("clear"))
			{
				Notes.console.cls();
			}
			else if(debugMode)
			{
				if(comm.startsWith("debugcpu"))
				{
					//Hangs main program execution...
					cpu.run();
				}
				else if(comm.startsWith("verinfo"))
				{
					Notes.console.dPrint("Notes by WareHouse Software");
					Notes.console.dPrint("Currently Version " + Notes.getVersion());
					Notes.console.dPrint("Note that this is Beta Software! It does not represent the final product!");
				}
				if(comm.startsWith("rungc"))
				{
					System.gc();
					Notes.console.dPrint(Types.SYSTEM, "Garbage Collection Run!");
				}
			}
			else 
			{
				System.out.println("INVALID COMMAND");
			}
		}
		else
		{
			Notes.console.dPrint("Invalid command: " + command);
			Notes.console.clearInput();
		}
	}
	
	
	/* Dumps to contents of the console to a text file. */
	public static void dumpToLog()
	{
		String filename = "log.txt";
		String line;
		String date = String.format("%tc", new Date(System.currentTimeMillis()));
		try
		{
			PrintWriter writer = new PrintWriter(filename);
			writer.println("NOTES LOG \n");
			writer.println(date + " \n");
			writer.println(Notes.console.getText() + "" + " \n");
			writer.close();
			Notes.console.dPrint("Successfully dumped console log!");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void dummyCommand(String rand)
	{
		if(rand.equals("/?"))
		{
			Notes.console.dPrint("This is a dummy command with arguments!");
		}
		else if(rand.equals(""))
		{
			
		}
		
		Notes.console.dPrint("You parsed the command " + rand);
	}
	
	public void crash(int exc)
	{
		Watchdog.quitWithException(exc);
	}
	
	public void switchLang(String args)
	{
		NotesLangFile lang = new NotesLangFile();
		File langF = new File("lang/" + args);
		lang.readLangFile(langF);
		Notes.console.dPrint(Types.SYSTEM, "Languaged has been changed to: " + args);
		Notes.npropfile.savePropToPropFile("lang", args, "notes.config");
	}
	
	private void changeBGColour(int r, int g, int b)
	{
		NotesFrame.textArea.setBackground(new Color(r, g, b));
	}
}