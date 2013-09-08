/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	Jazzy SpellCheck Library used in this class, released under the GNU.
	Use this... For now.
	
	The spellchecker will only engage if there's an incorrect word in the text.
	
	Two dictionaries are here. english.0 (the one that jazzy came with) and dictionary_eng.txt (one I found online).
	Dictionary_eng.txt is more comprehensive and contains letters as well as words (english.0 does not)

/--**/
package com.whsoftwareinc.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.swing.JTextComponentSpellChecker;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTextBox;

public class JazzySpellCheckMenuListener implements ActionListener {
	public static String englishDictionary = "res/english.0";
	public static String englishDictionary2 = "res/dictionary_eng.txt";
	protected SpellDictionary dictionary;
	public void actionPerformed(ActionEvent arg0)
	{
		/* Init Dictionary */
		File dictFile = new File(englishDictionary2);
		
		try
		{
			dictionary = new SpellDictionaryHashMap(dictFile);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		/* Draw the SpellCheck frame */
		JTextComponentSpellChecker sc = new JTextComponentSpellChecker(dictionary);
		NotesTextBox text = NotesFrame.textArea;
		sc.spellCheck(text);
	}
}