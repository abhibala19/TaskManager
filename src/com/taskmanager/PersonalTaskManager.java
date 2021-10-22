package com.taskmanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonalTaskManager {

	public static void main(String[] args) {
		try {
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			Logger.getInstance().log("task manager starts");
			int ch1 = 0, ch2 = 0, priority = 0;
			String catName, taskName, description, tag;
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM//yy");

			TaskModel model = new TaskModel();
			while (ch1 != 6) {
				System.out.println("press 1 to add Category");
				System.out.println("press 2 to load Category");
				System.out.println("press 3 to Search Category");
				System.out.println("press 4 to  list Category");
				System.out.println("press 5 to exit");
				System.out.println("Enter your choice");
				ch1 = sc1.nextInt();
				switch (ch1) {
				case 1:
					System.out.println("adding Category");
					System.out.println("enter  Category name");
					catName = sc2.nextLine();
					String result = TaskUtil.validateName(catName);
					while (!result.equals(Constants.SUCCESS)) {
						System.out.println(
								"enter proper name ,it contains single word with no special character and starts with letters");
						catName = sc1.next();
						result = TaskUtil.validateName(catName);
					}
					if (model.checkCategoryExists(catName)) {
						System.out.println("you are giving duplicate category name please give valid name");
					} else {
						while (ch2 != 6) {
							System.out.println("press 1 to add task");
							System.out.println("press 2 to edit task");
							System.out.println("press 3 to search task");
							System.out.println("press 4 to list task");
							System.out.println("press 5 to delete task");
							System.out.println("press 6 to go back");
							System.out.println("enter your choice");
							ch2 = sc1.nextInt();
							switch (ch2) {
							case 1:
								System.out.println("adding task");
								System.out.println("Enter task Name");
								taskName = sc2.nextLine();
								System.out.println("enter description for the task");
								description = sc2.nextLine();
								System.out.println("enter priority for the task 1-low 10-high ");
								priority = sc1.nextInt();
								System.out.println("enter the planned due date dd//MM//yy");
								String duedate = sc2.nextLine();
								Date date = dt.parse(duedate);

								System.out.println("enter tags(comma seperated");
								tag = sc2.nextLine();
								TaskBean bean = new TaskBean(taskName, description, tag, priority, date);
								String result2=model.addTask(bean,catName);
								if(result.equals(Constants.SUCCESS))
									System.out.println("task "+ taskName+" got added successfully");
								else
									System.out.println("task addition failed .msg is "+result);
								break;
							case 2:
								

							}
						}

					}

				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}