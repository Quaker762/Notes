/**++/
*
*	Copyright (c)  2013 WareHouse Software, Pty, Ltd
*
*	
*	All Rights Reserved
*                                                
/--**/
package com.whsoftwareinc.exception;

public class UnexpectedTerminationException extends Exception{
	
	public UnexpectedTerminationException()
	{
		super();
	}
	
	public UnexpectedTerminationException(Exception ex)
	{
		super(ex);
	}
	
	public UnexpectedTerminationException(Exception ex, String s)
	{
		super(ex);
		System.err.println(s);
	}

}
