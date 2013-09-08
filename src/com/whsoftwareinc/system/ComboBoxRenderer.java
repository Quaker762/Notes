/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.system;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends DefaultListCellRenderer{
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		JLabel fontName = new JLabel();
		fontName.setFont(list.getFont());
		Font font = (Font)value;
		fontName.setText(font.getName());
		Dimension dmn = fontName.getPreferredSize();
		Font derivedFont = font.deriveFont((float)dmn.getHeight());
		fontName.setFont(derivedFont);
		fontName.setMinimumSize(dmn);
		fontName.setPreferredSize(dmn);
		fontName.setOpaque(true);
		if (isSelected) {
		fontName.setBackground(list.getSelectionBackground());
		fontName.setForeground(list.getSelectionForeground());
		
		if(isSelected)
		{
			fontName.setBackground(list.getSelectionBackground());
			fontName.setForeground(list.getSelectionForeground());
		}
		else
		{
			fontName.setBackground(list.getBackground());
			fontName. setForeground(list.getForeground());
		}
	}
		return fontName;
	}
}
