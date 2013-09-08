package com.whsoftwareinc.exception;

import com.whsoftwareinc.debug.SystemConsole;


public class UnknownLanguageException extends Exception{
	
	private static final long serialVersionUID = 2481781614733128037L;

	public UnknownLanguageException()
	{
		System.err.println("UNKNOWN LANGUAGE!");
		SystemConsole.console.append("Unknown Language! Unable to switch!");
	}
	
	public UnknownLanguageException(String message)
	{
		System.err.println("UNKNOWN LANGUAGE!");
	}

}
