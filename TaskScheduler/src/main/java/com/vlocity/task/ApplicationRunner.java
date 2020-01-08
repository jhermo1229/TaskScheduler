package com.vlocity.task;

import com.vlocity.task.services.EndTaskService;
import com.vlocity.task.services.GetTaskService;
import com.vlocity.task.services.PostTaskService;
import com.vlocity.task.services.StartTaskService;

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
		System.out.print("Choose task todo: [G]et all task, [C]reate new task, [S]tart task. [E]nd task :");
		Scanner s = new Scanner(System.in);
		String input = s.next();

		if (input.equalsIgnoreCase("C"))
		{
			PostTaskService postTask = new PostTaskService();
			postTask.createTask();
		}
		else if (input.equalsIgnoreCase("G"))
		{
			GetTaskService getTask = new GetTaskService();
			List<Task> taskList = getTask.getAllTasks();
			TaskSchedulerUtil.getInstance().printTasks(taskList);
		}
		else if (input.equalsIgnoreCase("S"))
		{
			StartTaskService startTask = new StartTaskService();
			startTask.startTask();
		}
		else if (input.equalsIgnoreCase("E"))
		{
			EndTaskService endTask = new EndTaskService();
			endTask.endTask();
		}
	}
}
