package com.log4j;

import org.apache.log4j.Logger;

//import com.sun.istack.logging.Logger;

public class Log 
{
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void info(String message)
	{
		Log.info(message);
	}
	

}
