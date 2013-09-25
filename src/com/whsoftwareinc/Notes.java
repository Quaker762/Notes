/**++/

 Copyright (c)  2013 WareHouse Software, Pty, Ltd

 Notes Remake 2013
 Code a LOT cleaner than the original. The original architecture and functionality
 of the program will be exactly the same, and it should be much easier to implements
 features due to this. Much easier to read ^_^

 12/04/13 First bring up version	Jesse
 12/04/13 Added plugin functionality	Jesse

/--**/
package com.whsoftwareinc;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.text.Highlighter;

import com.whsoftwareinc.copyprotect.CheckKey;
import com.whsoftwareinc.copyprotect.NotesCK;
import com.whsoftwareinc.copyprotect.NotesCK.Type;
import com.whsoftwareinc.debug.CPUMonitor;
import com.whsoftwareinc.debug.MemoryMonitor;
import com.whsoftwareinc.debug.SystemConsole;
import com.whsoftwareinc.debug.SystemConsole.Types;
import com.whsoftwareinc.plugins.Plugin;
import com.whsoftwareinc.system.NotesLangFile;
import com.whsoftwareinc.system.NotesPropFile;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTabbedPane;
import com.whsoftwareinc.ui.NotesTextBox;
//import java.nio.file.Files;

public class Notes {

	/* Declare all variables up here! ^_^ */
	public static NotesFrame frame;
	public CPUMonitor cpum = new CPUMonitor();
	public MemoryMonitor memm = new MemoryMonitor();
	public CheckKey check = new CheckKey();
	public static boolean alreadyChecked = false;
	public NotesTabbedPane tabs = new NotesTabbedPane();
	public NotesCK check2 = new NotesCK();
	public boolean debugmode = false;
	public boolean safemode = false;
	private File sFile = new File("smode.err");
	
	private NotesLangFile lang = new NotesLangFile();
	
	public NotesTextBox text = new NotesTextBox();
	/* Put constants here */

	/* Put static variables here */
	public static final String verNum = "0.3";
	/* Reference of the Notes Property file */
	public static NotesPropFile npropfile = new NotesPropFile();
	/* Notes console */
	public static SystemConsole console = new SystemConsole();

	/* Text Area highlighter */
	public static Highlighter highlighter = NotesFrame.textArea.getHighlighter();

	public static void main(String[] args)
	{
		Notes notes = new Notes();
		notes.go();
	}

	public void go()
	{
		/* Call methods up here */
		
		//Does the safemode file exist?
		if(sFile.exists())
		{
			//YES! Notes terminated unexpectedly!
			safemode = true;
		}
		else
		{
			try
			{
				loadPlugins();
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch (InstantiationException e)
			{
				e.printStackTrace();
			} 
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}

		npropfile.readPropFile();
		npropfile.createPropFile();
		
		if(debugmode)
		{
			initSystem();
			console.dPrint(Types.SYSTEM, "Notes is running in debug mode!");
		}
		else if(safemode)
		{
			initSystemSafemode(); //Initialise in safe mode.
			console.dPrint(Types.SYSTEM, "Something went wrong! Notes has started in safe mode!");
		}
		
		if (npropfile.prop.getProperty("serial").equals(""))
		{
			System.out.println("Prop key blank!");
			check2.checkKey();
		}
		else if(NotesCK.CK_CheckKey(npropfile.prop.getProperty("serial"))  == Type.KEY_GOOD && !debugmode && !safemode)
		{
			System.out.println("Checked Key from prop!");
			initSystem();
		}
	}

	public void loadPlugins() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		File dir = new File("plugs/");
		String[] plugins = dir.list();
		URL loadPath = dir.toURI().toURL();
		URL[] classURL = new URL[] { loadPath };

		if (plugins == null)
		{
			console.dPrint(Types.WARNING, "System plugins null!");
			return; //Exit this method. 
		} 
		else
		{
			for (int i = 0; i < plugins.length; i++)
			{
				plugins[i].lastIndexOf(".");
				ClassLoader cl = new URLClassLoader(classURL);
				Class loadedClass = cl.loadClass("com.whsoftwareinc.plugins.classes." + stripExtension(plugins[i]));
				Plugin pluginInstance = (Plugin) loadedClass.newInstance();
				pluginInstance.init();
				System.out.println(pluginInstance.name());
			}
			console.dPrint(Types.SYSTEM, "Plugins loaded successfully!");
		}
	}

	public static String stripExtension(String str)
	{
		if (str == null)
			return null;

		int pos = str.lastIndexOf(".");

		if (pos == -1)
			return str;

		return str.substring(0, pos);
	}
	
	public static String getVersion()
	{
		return verNum;
	}
	
	public static void exit()
	{
		System.exit(0);
	}

	public void initSystem()
	{
		/**
		If you want the Default Windows Look and feel lol
		Looks REALLLLLY Weird lol
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		*/
		/* Set up variables below here */
		frame = new NotesFrame(1000, 850, "Notes WareHouse Software Beta " + verNum, "res/NotesLogo.png");
		/* Put methods needed for launch here. */
		//Tabs are experimental, and do not currently work correctly.
		frame.render(false, false);
		console.dPrint(Types.SYSTEM, "Frame initialised at size:" + frame.getWidth() + ", " + frame.getHeight());
		//FIX: Fix the no render bug by forcing the frame to resize.
		frame.setSize(1000, 851);
		// HACK: Set the font of the text area
		NotesFrame.textArea.setFont(Font.decode(npropfile.prop.getProperty("font")));
		
		lang.readLangFile(new File("lang/" + npropfile.prop.getProperty("lang").toLowerCase()));
		//System.out.println(npropfile.prop.getProperty("lang"));
		/* Put any threads here */
		//cpum.start();
		//memm.start();
	}
	
	//If the program quit unexpectedly, init in safemode
	private void initSystemSafemode()
	{
		frame = new NotesFrame(1000, 850, "Notes WareHouse Software Beta " + verNum + " SAFEMODE", "res/NotesLogo.png");
		frame.render(false, false);
		NotesFrame.textArea.setForeground(Color.BLACK);
		NotesFrame.textArea.setBackground(Color.WHITE);
		console.dPrint(Types.SYSTEM, "Frame initialised at size:" + frame.getWidth() + ", " + frame.getHeight());
		frame.setSize(1000, 849);
		//Delete the "Safemode" file.
		sFile.delete();
	}
}