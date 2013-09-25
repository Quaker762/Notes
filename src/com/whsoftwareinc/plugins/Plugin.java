/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.plugins;

public interface Plugin {

	/* Get the name of the plugin */
	public String getPluginName();

	/* Initialise the plugin */
	public void init();
	
	/* Set the name of the plugin */
	public String name();
}
