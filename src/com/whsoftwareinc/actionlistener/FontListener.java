package com.whsoftwareinc.actionlistener;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.debug.SystemConsole;
import com.whsoftwareinc.ui.NotesFrame;
import com.whsoftwareinc.ui.NotesTabbedPane;

public class FontListener implements ActionListener {
	
	public void actionPerformed(ActionEvent ev)
	{
		Font[] fonts = NotesFrame.genv.getAllFonts();
		JComboBox selFont = (JComboBox)ev.getSource();
		String font = (String)selFont.getSelectedItem();
		NotesFrame.textArea.setFont(Font.decode(font.toString()));
		Notes.console.dPrint(SystemConsole.Types.SYSTEM, "Font was changed to: " + font);
		
		Notes.npropfile.savePropToPropFile("font", font, "notes.config");
	}
}
