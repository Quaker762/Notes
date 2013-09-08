/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.debug;

import com.whsoftwareinc.system.Watchdog;
import com.whsoftwareinc.system.OSMemoryInfo;

public class MemoryMonitor implements Runnable {
	
	public OSMemoryInfo meminfo = new OSMemoryInfo();
	
	
	public MemoryMonitor()
	{
		
	}
	
	public void run()
	{
		while(true)
		{
			/*Get the cpu usage and print it*/
			System.out.println(calculateMemUsage());
			
			try
			{
				Thread.sleep(1200);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}	
		}
	}
	
	/* Calculate and return memory usage of the program */
	public long calculateMemUsage()
	{
		long currentMem = meminfo.totalMem - meminfo.freeMem / OSMemoryInfo.MEGABYTE;
		
		return currentMem;
	}

}
