/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.copyprotect;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.whsoftwareinc.Notes;

public class NotesCK {
	
	public static final double VERSION = 0.2;
	private static final byte[][] bytes = new byte[][] { { 24, 4, 127 }, { 10, 0, 56 }, { 1, 2, 91 }, { 7, 1, 100 } };
	
	public NotesCK()
	{
		
	}
	
	public ImageIcon icon = new ImageIcon("res/checkkey.png");
	
	/*Main copy protect method*/
	public void checkKey()
	{
		boolean checked = false;
  		
		String serial = (String)JOptionPane.showInputDialog(null, "Enter Serial Key", "CheckKey v" + VERSION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
		//CK_CheckKey(serial);
		
		/*http://www.brandonstaggs.com/2007/07/26/implementing-a-partial-serial-number-verification-system-in-delphi/*/
		Notes.npropfile.readPropFile();
		
		if(CK_CheckKey(serial) == Type.KEY_GOOD)
		{		
			/*Initialise what you want to here*/
			System.out.println("Key Valid! Proceeding!");
			Notes notes = new Notes();
			Notes.npropfile.readPropFile();
			try
			{
				Notes.npropfile.prop.load(new FileInputStream("notes.config"));
				Notes.npropfile.prop.setProperty("serial", serial);
				Notes.npropfile.prop.store(new FileOutputStream("notes.config"), null);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			notes.initSystem();
		}
		else
		{
			System.out.println("Key is invalid!!");
			JOptionPane.showConfirmDialog(null, "Key is invalid!");
			checkKey();
		}
	}
	
	public static void main(String[] args)
	{
		NotesCK main = new NotesCK();
		main.checkKey();
	}
	
	
	public static byte CK_GetKeyByte(final int seed, final byte a, final byte b, final byte c)
	{
		final int a1 = a % 25;
		final int b1 = b % 3;
		
		if(a % 2 == 0)
		{
			return (byte) (((seed >> a1) & 0x000000FF) ^ ((seed >> b1) | c));
		}
		else
		{
			return (byte) ((((seed >> a1) & 0x000000FF) ^ ((seed >> b1) & c)));
		}
	}
	
	 public String CK_GetChecksum(final String s) {
	        int left = 0x0056;
	        int right = 0x0EAF;
	        for (byte b : s.getBytes()) 
	        {
	            right += b;
	            if (right > 0x00FF) 
	            {
	                right -= 0x00FF;
	            }
	            left += right;
	            if (left > 0x00FF) 
	            {
	                left -= 0x00FF;
	            }
	        }
	        int sum = (left << 8) + right;
	        return intToHex(sum, 4);
	    }
	
	 public String CK_MakeKey(final int seed) 
	 {
		 	final byte[] keyBytes = new byte[4];
	        keyBytes[0] = CK_GetKeyByte(seed, bytes[0][0], bytes[0][1], bytes[0][2]);
	        keyBytes[1] = CK_GetKeyByte(seed, bytes[1][0], bytes[1][1], bytes[1][2]);
	        keyBytes[2] = CK_GetKeyByte(seed, bytes[2][0], bytes[2][1], bytes[2][2]);
	        keyBytes[3] = CK_GetKeyByte(seed, bytes[3][0], bytes[3][1], bytes[3][2]);

	        final StringBuilder result = new StringBuilder(intToHex(seed, 8));

	        for (byte b : keyBytes) {
	            result.append(intToHex(b, 2));
	        }

	        result.append(CK_GetChecksum(result.toString()));

	        final String key = result.toString();
	        return key.substring(0, 4) + "-" + key.substring(4, 8) + "-" + key.substring(8, 12) + "-" + key.substring(12, 16) + "-" + key.substring(16, 20);
	  }
	
	public boolean CK_CheckKeyChecksum(final String key)
	{
		final String comp = key.replaceAll("-", "").toLowerCase();
		
		if(comp.length() != 20)
		{
			return false;
		}
		
		final String checksum = comp.substring(16);
		
		return checksum.equals(CK_GetChecksum(comp.substring(0, 16)));
	}
	   
	  public static Type CK_CheckKey(final String key) {
		  
	        final String comp = key.replaceAll("-", "").toLowerCase(Locale.UK);
	        
	        final int seed = Integer.valueOf(comp.substring(0, 8), 16);

	        final String kb0 = comp.substring(8, 10);
	        final byte b0 = CK_GetKeyByte(seed, bytes[0][0], bytes[0][1], bytes[0][2]);
	        if (!kb0.equals(intToHex(b0, 2))) 
	        {
	        	System.out.println("KEYCHECK BOGUS!!");
	        	return Type.KEY_PHONY;
	        }

	        final String kb1 = comp.substring(10, 12);
	        final byte b1 = CK_GetKeyByte(seed, bytes[1][0], bytes[1][1], bytes[1][2]);
	        if (!kb1.equals(intToHex(b1, 2))) 
	        {
	        	System.out.println("KEYCHECK BOGUS!!");
	        	return Type.KEY_PHONY;
	        }

	        final String kb2 = comp.substring(12, 14);
	        final byte b2 = CK_GetKeyByte(seed, bytes[2][0], bytes[2][1], bytes[2][2]);
	        if (!kb2.equals(intToHex(b2, 2))) 
	        {
	        	System.out.println("KEYCHECK BOGUS!!");
	        	return Type.KEY_PHONY;
	        }

	        final String kb3 = comp.substring(14, 16);
	        final byte b3 = CK_GetKeyByte(seed, bytes[3][0], bytes[3][1], bytes[3][2]);
	        if (!kb3.equals(intToHex(b3, 2))) 
	        {
	        	System.out.println("KEYCHECK BOGUS!!");
	        	return Type.KEY_PHONY;
	        }
	            
	        return Type.KEY_GOOD;
	    }   
	
	protected static String intToHex(final Number n, final int chars) 
	{
        return String.format("%0" + chars + "x", n);
    }
	
	public enum Type
	{
        KEY_GOOD, KEY_INVALID, KEY_BLACKLISTED, KEY_PHONY
    }

}
