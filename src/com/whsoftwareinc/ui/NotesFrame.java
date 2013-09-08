/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd
	
	Automatic PNG extension adder for if this is ever used outside of notes.
	(Removed for now because it didn't work :( )
	
	Some things will have to be static due to outside usage.

/--**/
package com.whsoftwareinc.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.actionlistener.ConvertCaseLowerActionListener;
import com.whsoftwareinc.actionlistener.ConvertCaseUpperActionListener;
import com.whsoftwareinc.actionlistener.CopyMenuListener;
import com.whsoftwareinc.actionlistener.CutMenuListener;
import com.whsoftwareinc.actionlistener.DebugConsoleActionListener;
import com.whsoftwareinc.actionlistener.ExitMenuListener;
import com.whsoftwareinc.actionlistener.FontListener;
import com.whsoftwareinc.actionlistener.InsertDateMenuListener;
import com.whsoftwareinc.actionlistener.JazzySpellCheckMenuListener;
import com.whsoftwareinc.actionlistener.NewMenuListener;
import com.whsoftwareinc.actionlistener.OpenMenuListener;
import com.whsoftwareinc.actionlistener.OptionsMenuActionListener;
import com.whsoftwareinc.actionlistener.PasteMenuListener;
import com.whsoftwareinc.actionlistener.SaveMenuListener;
import com.whsoftwareinc.actionlistener.SearchMenuListener;
import com.whsoftwareinc.actionlistener.SelectMenuListener;
import com.whsoftwareinc.actionlistener.SupportMenuListener;
import com.whsoftwareinc.actionlistener.UpdateActionListener;
import com.whsoftwareinc.actionlistener.VisitUsMenuListener;
import com.whsoftwareinc.actionlistener.WordCountMenuListener;
import com.whsoftwareinc.system.ComboBoxRenderer;

public class NotesFrame extends JFrame{
	
	int width;
	int height;
	String title;
	String logo;
	public static JEditorPane editpane = new JEditorPane();
	public static  NotesTextBox textArea = new NotesTextBox(1000, 850);
	public static NotesTabbedPane tabs = new NotesTabbedPane();
	public static GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
	public JMenuBar menuBar = new JMenuBar();
	public JMenuBar macroBar = new JMenuBar();
	public JMenuBar bottomBar = new JMenuBar();
	public JMenu fileMenu = new JMenu("File");
	public JMenu editMenu = new JMenu("Edit");
	public JMenu helpMenu = new JMenu("Help");
	public JMenu utilsMenu = new JMenu("Utilities");
	public JMenu optionsMenu = new JMenu("Options");
	public JMenu editSubmenu = new JMenu("Case");
	
	/*All the elements in the File menu*/
	public JMenuItem newMenuItem = new JMenuItem("New");
	public JMenuItem openMenuItem = new JMenuItem("Open");
	public JMenuItem saveMenuItem = new JMenuItem("Save");
	public JMenuItem notesSaveMenuItem = new JMenuItem("Save (Test)");
	public JMenuItem printMenuItem = new JMenuItem("Print");
	public JMenuItem exitMenuItem = new JMenuItem("Exit");
	
	/*All the elements in the edit menu*/
	public JMenuItem selectAllMenuItem = new JMenuItem("Select All");
	public JMenuItem copyMenuItem = new JMenuItem("Copy");
	public JMenuItem pasteMenuItem = new JMenuItem("Paste");
	public JMenuItem cutMenuItem = new JMenuItem("Cut");
	public JMenuItem searchMenuItem = new JMenuItem("Search");
	public JMenuItem currdateMenuItem = new JMenuItem("Current Date");
	public JMenuItem wordcountMenuItem = new JMenuItem("Word Count");
	public JMenuItem spellCheckMenuItem = new JMenuItem("Check Spelling *TEST*");
	
	//Everything in the edit Submenu
	public JMenuItem uppercase = new JMenuItem("UPPERCASE");
	public JMenuItem lowercase = new JMenuItem("lowercase");
	
	/*All the elements in the help menu*/
	public JMenuItem aboutMenuItem = new JMenuItem("About");
	public JMenuItem supportMenuItem = new JMenuItem("Support");
	public JMenuItem visitUsMenuItem = new JMenuItem("Visit Us");
	public JMenuItem helpMenuItem = new JMenuItem("Help");
	
	/*Image Icons for the macrobar*/
	public JButton newButton = new JButton();
	Icon newButtonIcon = new ImageIcon("res/buttons/page_add.png");
	public JButton saveButton = new JButton();
	Icon saveButtonIcon = new ImageIcon("res/buttons/disk.png");
	public JButton openButton = new JButton();
	Icon openButtonIcon = new ImageIcon("res/buttons/folder.png");
	public JComboBox fontbox = new JComboBox(genv.getAvailableFontFamilyNames());
	public ComboBoxRenderer renderer = new ComboBoxRenderer();
	
	/*Bottom Bar Components*/
	public JTextField wordCountField = new JTextField();
	
	/*All the stuff in the Utilities menu*/
	public JMenuItem updateMenuItem = new JMenuItem("Check for Updates");
	
	//TextFX maybe
	
	//Debug Window
	public JMenuItem debugConsoleMenuItem = new JMenuItem("Console");
	
	/*All the stuff in the options menu*/
	public JMenuItem optionsMenuItem = new JMenuItem("Options");
	public JMenuItem systemSpecsMenuItem = new JMenuItem("System Specifications");

	/*----------------------------------------------------------------------------
    Name        : Constructor
    Description : Constructor for the frame
    Inputs      : int, int, String, String
    Outputs     : 
    Return      :
	----------------------------------------------------------------------------*/
	public NotesFrame(int width, int height, String title, String logo)
	{
		this.width = width;
		this.height = height;
		this.setTitle(title);
		this.logo = logo;
		this.setIconImage(new ImageIcon(logo).getImage());
		this.addWindowListener(new NotesFrameListener());
		//Not for now
		//this.logo = logo;
	}
	
	/*----------------------------------------------------------------------------
    Name        : render
    Description : Renders the frame to the screen. Supports tabbed edit pane
    Inputs      : boolean editor, boolean tabbed
    Outputs     : 
    Return      :
	----------------------------------------------------------------------------*/
	public void render(boolean editor, boolean tabbed)
	{
		JScrollPane scrollBar = new JScrollPane(textArea);
		JScrollPane scrollBarPane = new JScrollPane(editpane);
		
		newButton.setIcon(newButtonIcon);
		saveButton.setIcon(saveButtonIcon);
		openButton.setIcon(openButtonIcon);
		newButton.addActionListener(new NewMenuListener());
		saveButton.addActionListener(new SaveMenuListener());
		openButton.addActionListener(new OpenMenuListener());
		
		setVisible(true);
		setSize(width, height);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(menuBar);
		add(macroBar, BorderLayout.NORTH);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		menuBar.add(utilsMenu);
		menuBar.add(optionsMenu);
		macroBar.add(newButton);
		macroBar.add(openButton);
		macroBar.add(saveButton);
		
		menuBar.add(fontbox);
		//Stuff to do with the font ComboBox...
		fontbox.addActionListener(new FontListener());
		fontbox.setMaximumRowCount(5);
		fontbox.setMaximumSize(new Dimension(200, 300));
		fontbox.setSelectedItem(Notes.npropfile.prop.getProperty("font"));
		//fontbox.setRenderer(renderer);
		
		add(bottomBar, BorderLayout.SOUTH);
		
		/*FileMenu*/
		fileMenu.add(newMenuItem);
		newMenuItem.addActionListener(new NewMenuListener());
		fileMenu.add(openMenuItem);
		openMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(saveMenuItem);
		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(printMenuItem);
		
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ExitMenuListener());
		
		/*Edit Menu*/
		editMenu.add(selectAllMenuItem);
		selectAllMenuItem.addActionListener(new SelectMenuListener());
		
		editMenu.add(copyMenuItem);
		copyMenuItem.addActionListener(new CopyMenuListener());
		
		editMenu.add(pasteMenuItem);
		pasteMenuItem.addActionListener(new PasteMenuListener());
		
		editMenu.add(cutMenuItem);
		cutMenuItem.addActionListener(new CutMenuListener());
		
		editMenu.add(searchMenuItem);
		searchMenuItem.addActionListener(new SearchMenuListener());
		
		editMenu.add(wordcountMenuItem);
		wordcountMenuItem.addActionListener(new WordCountMenuListener());
		
		editMenu.add(currdateMenuItem);
		currdateMenuItem.addActionListener(new InsertDateMenuListener());
		
		editMenu.add(spellCheckMenuItem);
		spellCheckMenuItem.addActionListener(new JazzySpellCheckMenuListener());
		
		editMenu.addSeparator();
		
		editMenu.add(editSubmenu);
		editSubmenu.add(uppercase);
		uppercase.addActionListener(new ConvertCaseUpperActionListener());
		
		editSubmenu.add(lowercase);
		lowercase.addActionListener(new ConvertCaseLowerActionListener());
		
		
		
		/*Help Menu*/
		helpMenu.add(aboutMenuItem);
		
		supportMenuItem.addActionListener(new SupportMenuListener());
		helpMenu.add(supportMenuItem);
		
		visitUsMenuItem.addActionListener(new VisitUsMenuListener());
		helpMenu.add(visitUsMenuItem);
		
		helpMenu.add(helpMenuItem);
		
		/*Utils menu*/
		debugConsoleMenuItem.addActionListener(new DebugConsoleActionListener());
		utilsMenu.add(debugConsoleMenuItem);
		updateMenuItem.addActionListener(new UpdateActionListener());
		utilsMenu.add(updateMenuItem);
		
		/*Options Menu*/
		optionsMenuItem.addActionListener(new OptionsMenuActionListener());
		optionsMenu.add(optionsMenuItem);
		
		
		/*Key Modifiers here, such as Control+S etc*/
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		debugConsoleMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		if(editor)
		{
			getContentPane().add(scrollBarPane, BorderLayout.EAST);
			add(scrollBarPane);
		}
		else if(tabbed)
		{
			tabs.createNewTextTab();
			add(tabs);
			requestFocus();
		}
		else
		{
			requestFocus();
			scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			getContentPane().add(scrollBar);
			add(scrollBar);
			requestFocus();
		}
	}
}
