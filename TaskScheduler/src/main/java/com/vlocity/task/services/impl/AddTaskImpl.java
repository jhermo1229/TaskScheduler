package com.vlocity.task.services.impl;

import com.vlocity.task.Task;
import com.vlocity.task.services.AddTask;
import com.vlocity.task.services.RetrieveTasks;

import com.vlocity.util.TaskSchedulerUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class AddTaskImpl implements AddTask
{
	//~ Methods ----------------------------------
	/** DOCUMENT ME! */
	@SuppressWarnings("resource")
	public Task createNewTask()
	{
		Task task = new Task();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Task Name: ");
		task.setTaskName(s.nextLine());
		System.out.println("Enter start date (YYYYmmdd): ");
		task.setStartDate(s.nextInt());
		System.out.println("Enter end date (YYYYmmdd): ");
		task.setEndDate(s.nextInt());
		System.out.println("Any task dependency?: ");
		String dependency = s.next();
		RetrieveTasks getTask = new RetrieveTasksImpl();
		List<Task> taskList = getTask.getAllTasks();
		if (dependency.equalsIgnoreCase("Y"))
		{
			TaskSchedulerUtil.getInstance().printTasks(taskList);
			System.out.println("");
			boolean isValid = false;
			while (!isValid)
			{
				System.out.println("Please choose task ID of dependent task:");
				isValid = validateInput(task, taskList, isValid);
			}
		}
		else
		{
			task.setDependentTaskId(0);
		}
		task.setId(taskList.size() + 1);

		return task;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param   task
	 * @param   taskList
	 * @param   isValid
	 * @return
	 */
	@SuppressWarnings("resource")
	private boolean validateInput(Task task, List<Task> taskList, boolean isValid)
	{
		Scanner input = new Scanner(System.in);

		int dependentId = input.nextInt();
		for (Task existingTask : taskList)
		{
			if (existingTask.getId() == dependentId)
			{
				task.setDependentTaskId(dependentId);

				isValid = true;
			}
		}

		return isValid;
	}
	
	/** @see  com.vlocity.task.services.AddTask#saveTask(com.vlocity.task.Task) */
	@Override
	public void saveTask()
	{
		Task task = createNewTask();
		// Open the file in append mode.
		FileWriter fw;

		try
		{
			fw = new FileWriter("Task.txt", true);
			PrintWriter out = new PrintWriter(fw);
			// Append the name of ocean to the file
			out.println(task.getId() + ";" + task.getTaskName() + ";" + task.getStartDate() + ";" + task.getEndDate()
				+ ";" + task.getDependentTaskId());

			// Close the file.
			out.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
