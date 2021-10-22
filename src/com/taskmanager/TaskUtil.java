package com.taskmanager;

public class TaskUtil {
	public static String validateName(String name)
	{
		if(name==null)
			throw new IllegalArgumentException("name cannot be null");
		if(name.trim().equals(""))
			return "name must be contain letters";
		String[] s=name.split(" ");
		if(s.length>1)
			return "name shoule contain only one word";
		for(int i=0;i<name.length();i++)
		{
			char c=name.charAt(i);
			if(!Character.isLetter(c) || Character.isDigit(c))
              return "name should not contains special  Characters";
		}
		return Constants.SUCCESS;
	}

}
