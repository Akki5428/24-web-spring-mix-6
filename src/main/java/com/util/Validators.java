package com.util;

public class Validators {

	public static boolean checkNull(String data)
	{
		if(data == null || data.trim().length()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isAlpha(String data)
	{
		String alpharegex = "[A-Za-z]+";
		
		return data.matches(alpharegex);
	}
	
}
