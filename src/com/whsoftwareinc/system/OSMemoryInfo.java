/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.system;

public class OSMemoryInfo {
	
	public static final int KILOBYTE = 1024;
	public static final int MEGABYTE = 1024 * 1024;
	public static final int GIGABYTE = 1024 * 1024 * 1024;
		
	public OSMemoryInfo()
	{
		
	}
	/*Maximum Memory that the JVM will use.*/
	public long maxMem = Runtime.getRuntime().maxMemory();
		
	/*Total Memory that the JVM can uses.*/
	public long totalMem = Runtime.getRuntime().totalMemory();
	
	/*Amount of Processors (Cores) the machine currently has.*/
	public int cpus = Runtime.getRuntime().availableProcessors();
	
	 /*Amount of Free Memory that the program has.*/
	public long freeMem = Runtime.getRuntime().freeMemory();

}
