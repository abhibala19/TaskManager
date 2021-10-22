package com.taskmanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Logger {
	public static Logger log;
	private boolean devMode = true;
	private String path = "/home/abhi/abhijava/documents/write.txt";

	private Logger() {
		System.out.println("in no arg constr");
	}

	public static Logger getInstance() {
		if (log == null)
			log = new Logger();
		return log;
	}

	public void log(final String data) {
		new Thread() {
			public void run() {
				BufferedWriter bw=null;
				try {
					bw = new BufferedWriter(new FileWriter(path, true));
					Date dt = new Date();
					bw.write(dt.toString() + ":" + data);
					bw.newLine();
					if(devMode)
						System.out.println(data);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (bw != null) {
						try {
							bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			}
		}.start();
	}
}