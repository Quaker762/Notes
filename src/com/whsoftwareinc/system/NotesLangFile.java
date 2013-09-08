/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.exception.UnknownLanguageException;
import com.whsoftwareinc.ui.NotesFrame;

public class NotesLangFile {
	
	/*All the stock standard .lang files that come with Notes.frame.
	  Probably won't ever be needed, but just in case*/
	public String[] knownLang = 
	{
		"english.lang",
		"chinasimp.lang",
		"croatian.lang",
		"dovah.lang",
		"dutch.lang",
		"english.lang",
		"french.lang",
		"german.lang",
		"greek.lang",
		"italian.lang",
		"japanese.lang",
		"latin.lang",
		"norwegian.lang",
		"pirate.lang",
		"russian.lang",
		"serbian.lang"
	};
	
	public static String confirm;
	
	public NotesLangFile()
	{
		
	}
	
	/*Read .lang file. Currently doesn't actually change anything*/
	//TODO: Make this function change some stuff to another language!
	
	public void readLangFile(File file)
	{
		/*Set up variables*/
		NotesFrame frame = Notes.frame;
		String in = "";
		int line = 0;
		
		try
		{
			FileInputStream fis = new FileInputStream(file);
			Reader freader = new InputStreamReader(fis, "utf-8");
			BufferedReader br = new BufferedReader(freader);
			
			while((in = br.readLine()) != null)
			{
				line++;
				if(line == 1)
				{
					Notes.frame.fileMenu.setText(in);
				}
                if(line == 2)
                {
                    Notes.frame.editMenu.setText(in);
                }
                if(line == 3)
                {
                    Notes.frame.helpMenu.setText(in);
                }
                if(line == 4)
                {
                    Notes.frame.utilsMenu.setText(in);
                }
                if(line == 5)
                {
                    Notes.frame.optionsMenu.setText(in);
                }
                if(line == 6)
                {
                    Notes.frame.newMenuItem.setText(in);
                }
                if(line == 7)
                {
                    Notes.frame.openMenuItem.setText(in);
                }
                if(line == 8)
                {
                    Notes.frame.saveMenuItem.setText(in);
                }
                if(line == 9)
                {
                    Notes.frame.printMenuItem.setText(in);
                }
                if(line == 10)
                {
                    Notes.frame.exitMenuItem.setText(in);
                }
                if(line == 11)
                {
                    Notes.frame.selectAllMenuItem.setText(in);
                }
                if(line == 12)
                {
                    Notes.frame.copyMenuItem.setText(in);
                }
                if(line == 13)
                {
                    Notes.frame.pasteMenuItem.setText(in);
                }
                if(line == 14)
                {
                    Notes.frame.cutMenuItem.setText(in);
                }
                if(line == 15)
                {
                    //Notes.frame.selectAllMenuItemUtil.setText(in);
                }
                if(line == 16)
                {
                    //Notes.frame.copyMenuItemUtil.setText(in);
                }
                if(line == 17)
                {
                   // Notes.frame.pasteMenuItemUtil.setText(in);
                }
                if(line == 18)
                {
                    //Notes.frame.cutMenuItemUtil.setText(in);
                }
                if(line == 19)
                {
                    Notes.frame.searchMenuItem.setText(in);
                }
                if(line == 20)
                {
                    Notes.frame.aboutMenuItem.setText(in);
                }
                if(line == 21)
                {
                Notes.frame.supportMenuItem.setText(in);  
                }
                if(line == 22)
                {
                    Notes.frame.helpMenuItem.setText(in);
                }
                if(line == 23)
                {
                    //Notes.frame.optionsMenuItem.setText(in);
                }
                if(line == 24)
                {
                    Notes.frame.systemSpecsMenuItem.setText(in);
                }
                if(line == 25)
                {
                    Notes.frame.currdateMenuItem.setText(in);
                }
                if(line == 26)
                {
                    Notes.frame.wordcountMenuItem.setText(in);
                }
                if(line == 27)
                {
                    //OptionsMenuListener.selectLang.setText(in);
                }
                if(line == 28)
                {
                   // OptionsMenuListener.tabs.add(in, OptionsMenuListener.pagePanel);
                }
                if(line == 29)
                {
                    //OptionsMenuListener.tabs.add(in, OptionsMenuListener.bgCol);
                }
                if(line == 30)
                {
                   // OptionsMenuListener.tabs.add(in, OptionsMenuListener.textCol);
                }
                if(line == 31)
                {
                    //OptionsMenuListener.tabs.add(in, OptionsMenuListener.highlightCol);
                }
                if(line == 32)
                {
                    //OptionsMenuListener.tabs.add(in, OptionsMenuListener.langpan);
                }
                if(line == 33)
                {
                	confirm = in;
                	System.out.println(line);
                }
            } 
			line = 0;
			in = "";
			br.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

