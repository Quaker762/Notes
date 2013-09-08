/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.plugins.classes;

import com.whsoftwareinc.plugins.PluginLoader;

public class Plugin1 implements PluginLoader {
	public void init() 
	{
		System.out.println("Hello World!");
	}

}
