/**++/

	Copyright (c)  2013 WareHouse Software, Pty, Ltd

/--**/

package com.whsoftwareinc.system;

public class OSVersionInfo {
	
	public OSVersionInfo()
	{
		
	}
	
	public boolean isWindows() {
		 
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("win") >= 0);
 
	}
 
	public boolean isMac() {
 
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("mac") >= 0);
 
	}
 
	public boolean isLinuxUnix() {
 
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
 
	}
 
	public boolean isSolaris() {
 
		String os = System.getProperty("os.name").toLowerCase();
		return (os.indexOf("sunos") >= 0);
 
	}
	/**++/
	 NOT ACTUALLY OPERATING SYSTEM ARCHITECTURE!!!!! THIS PRINTS THE JDK ARCH!!
	 */
	public String osArch = System.getProperty("os.arch");
	
	/**++/
	 Create this Variable so we can actually print the OSName in the program, 
	 not just in Debug
	 */
	public String osVersion = System.getProperty("os.name");
	
	/*Get the System Username*/
	public String userName = System.getProperty("user.name");
	
	public boolean is64 = "64".equals(System.getProperty("sun.arch.data.model")) || System.getProperty("os.arch").contains("64");
	
	
 
}

