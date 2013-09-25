/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.plugins.classes;

import com.whsoftwareinc.Notes;
import com.whsoftwareinc.plugins.Plugin;

public class Plugin1 implements Plugin {
	
	public String getPluginName()
	{
		return "Test Plugin 1";
	}
	
	public void init() 
	{
		System.out.println("Hello World!");
	}

	public String name()
	{
		return "Plugin V1";
	}
}
