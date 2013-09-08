/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.ui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class NotesButton extends JButton {

	/*Button with Image attached*/
	public NotesButton(BufferedImage image, String path)
	{
		try
		{
			image = ImageIO.read(NotesButton.class.getResource(path));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/*Button with Text only*/
	public NotesButton(String text)
	{
		this.setText(text);
	}
}
