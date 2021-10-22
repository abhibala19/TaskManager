package com.taskmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TaskModel {
	public List<TaskBean> getCategory(String catName)
	{
		BufferedReader br=null;
		try {
		br=new BufferedReader(new FileReader(catName+".todo"))	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
			{
				try {
					br.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public boolean checkCategoryExists(String catName)
	{
	return new File("/home/abhi/abhijava/taskmanager/"+catName+".todo").exists();	
	}
	public String addTask(TaskBean task,String catName)
	
	{
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(catName+".todo",true));
			Date dt=new Date();
			SimpleDateFormat sd=new SimpleDateFormat("dd//MM//yyyy");
			String f=sd.format(dt);
			bw.write(task.getTaskName()+":"+task.getDescription()+":"+task.getTag()+":"+f+":"+task.getDate()+dt.getTime());
			bw.newLine();
			return Constants.SUCCESS;
					
		}catch(IOException e)
		{
			e.printStackTrace();

			return "something bad happened"+e.getMessage();
		}finally {
			if(bw!=null)
			{
				try
				{
					bw.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}


	}}
