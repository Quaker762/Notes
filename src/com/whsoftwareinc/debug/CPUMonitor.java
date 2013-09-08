/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/
package com.whsoftwareinc.debug;

import com.whsoftwareinc.system.Watchdog;

public class CPUMonitor implements Runnable {
	
	public static boolean running = false;
	Watchdog ex = new Watchdog();
	
	public CPUMonitor()
	{
		
	}
	
	/*Thread for the CPU monitor*/
	public void run() 
	{
		/*While the program is running...*/
		while(true)
		{
			/*Get the cpu usage and print it*/
			//System.out.println("CPU:" + cpuUsage() / 100 + "%");
			
			/*Check if program is using too much cpu*/
			if(cpuUsage() / 100 > 70)
			{
				/*Yep, too much cpu. Terminate Program*/
				ex.quitWithException(Watchdog.EXCESS_CPU_USAGE);
			}
			
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
	
	public long cpuUsage()
	{
		long startTime = System.nanoTime();
		return System.nanoTime() - startTime;
	}
}
