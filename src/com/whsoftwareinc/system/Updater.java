/**++/

	2013 WareHouse Software, Pty, Ltd
 
http://www.dreamincode.net/forums/topic/190944-creating-an-updater-in-java/
/--**/
package com.whsoftwareinc.system;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Updater {
	
	private static final String versionURL = "https://sites.google.com/site/warehousesoftwareinc/version";
	private static final String historyURL = "https://sites.google.com/site/warehousesoftwareinc/version";
	
	public static String getLatestVersion() throws Exception
	{
		String data = getData(versionURL);
		return data.substring(data.indexOf("[version]")+9,data.indexOf("[/version]"));
	}
	
	public static String getUpdates() throws Exception
	{
		String data = getData(historyURL);
		return data.substring(data.indexOf("[history]")+9,data.indexOf("[/history]"));
	}
	
	public static String getData(String address) throws Exception
	{
		URL url = new URL(address);
		InputStream html = null;
		
		html = url.openStream();
		int c = 0;
		StringBuffer buffer = new StringBuffer("");
		
		while(c != -1)
		{
			c = html.read();
			buffer.append((char)c);
		}
		return buffer.toString();
	}
}
