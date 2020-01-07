package com.vlocity.task;

import com.vlocity.task.services.AddTask;
import com.vlocity.task.services.RetrieveTasks;
import com.vlocity.task.services.impl.AddTaskImpl;
import com.vlocity.task.services.impl.RetrieveTasksImpl;

import com.vlocity.util.TaskSchedulerUtil;

import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class ApplicationRunner
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  args
	 */
	public static void main(String[] args)
	{
		System.out.print("Choose task todo: [G]et all task, [C]reate new task :");
		Scanner s = new Scanner(System.in);
		String input = s.next();

		if (input.equalsIgnoreCase("C"))
		{
			AddTask addTask = new AddTaskImpl();
			addTask.saveTask();
		}
		else if (input.equalsIgnoreCase("G"))
		{
			RetrieveTasks getTask = new RetrieveTasksImpl();
			List<Task> taskList = getTask.getAllTasks();
			TaskSchedulerUtil.getInstance().printTasks(taskList);
		}
		else if (input.equalsIgnoreCase("R"))
		{
			//
		}
	}
}
