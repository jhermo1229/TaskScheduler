package com.vlocity.task;

import com.vlocity.task.model.Task;
import com.vlocity.task.service.EndTaskService;
import com.vlocity.task.service.GetTaskService;
import com.vlocity.task.service.PostTaskService;
import com.vlocity.task.service.StartTaskService;
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
	//~ Static fields/initializers ---------------
	/**  */
	private static final String END = "E";

	/**  */
	private static final String START = "S";

	/**  */
	private static final String GET = "G";

	/**  */
	private static final String CREATE = "C";
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  args
	 */
	public static void main(String[] args)
	{
		System.out.print("Choose task todo: [G]et all task, [C]reate new task, [S]tart task, [E]nd task :");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		taskProcess(input);
	}
	
	/**
	 * Processing of choice input
	 *
	 * @param  input
	 */
	private static void taskProcess(String input)
	{
		switch (input.toUpperCase())
		{
			case CREATE:
			{
				PostTaskService postTask = new PostTaskService();
				postTask.createTask();
				break;
			}

			case GET:
			{
				GetTaskService getTask = new GetTaskService();
				List<Task> taskList = getTask.getAllTasks();
				TaskSchedulerUtil.getInstance().printTasks(taskList);
				break;
			}

			case START:
			{
				StartTaskService startTask = new StartTaskService();
				startTask.startTask();
				break;
			}

			case END:
			{
				EndTaskService endTask = new EndTaskService();
				endTask.endTask();
				break;
			}
		}
	}
}
