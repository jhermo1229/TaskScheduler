package com.vlocity.task.service;

import com.vlocity.task.dao.PutTaskDao;
import com.vlocity.task.dao.impl.PutTaskDaoImpl;
import com.vlocity.task.model.Task;

import com.vlocity.util.TaskSchedulerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Start task
 *
 * @version  1
 */
public class StartTaskService
{
	//~ Static fields/initializers ---------------
	/**  */
	private static final String END = "E";

	/**  */
	private static final String STARTED = "S";

	/**  */
	private static final String NO_DEPENDENCY = "0";
	//~ Instance fields --------------------------
	/**  */
	private GetTaskService getTask = new GetTaskService();

	/**  */
	private PutTaskDao updateTask = new PutTaskDaoImpl();
	//~ Methods ----------------------------------
	/**
	 * @throws  Exception
	 * @see     com.vlocity.task.services.StartTask#startTask(java.lang.Integer)
	 */
	public void startTask()
	{
		List<Task> finalTaskList = new ArrayList<>();
		List<Task> notStartedList = new ArrayList<>();
		List<Task> taskList = getTask.getAllTasks();
		for (Task task : taskList)
		{
			if (!task.getFlag().contains(STARTED))
			{
				notStartedList.add(task);
			}
		}

		validateTaskStarted(notStartedList);

		TaskSchedulerUtil.getInstance().printTasks(notStartedList);
		System.out.println("Please choose task ID of task to start:");
		Scanner input = new Scanner(System.in);

		int taskId = input.nextInt();

		for (Task task : taskList)
		{
			if (task.getId() == taskId)
			{
				if (!task.getDependentTaskId().equals(NO_DEPENDENCY))
				{
					checkDependency(taskList, task);
				}
				else
				{
					StringBuilder flag = new StringBuilder(task.getFlag());
					flag.append(STARTED);
					task.setFlag(flag.toString());
				}
			}
			finalTaskList.add(task);
		} // end for
		updateTask.updateTask(finalTaskList);
	}
	

	/**
	 * DOCUMENT ME!
	 *
	 * @param  notStartedList
	 */
	private void validateTaskStarted(List<Task> notStartedList)
	{
		if (notStartedList.isEmpty())
		{
			System.out.println("No task available");
			System.exit(0);
		}
	}
	
	/**
	 * Dependent task checker
	 *
	 * @param  taskList
	 * @param  task
	 */
	private void checkDependency(List<Task> taskList, Task task)
	{
		char[] dependentList = task.getDependentTaskId().toCharArray();

		for (int i = 0; i < dependentList.length; i++)
		{
			char depId = dependentList[i];
			for (Task allTask : taskList)
			{
				if (allTask.getId() == Character.getNumericValue(depId))
				{
					if (allTask.getFlag().contains(END))
					{
						StringBuilder flag = new StringBuilder(task.getFlag());
						if (i == (dependentList.length - 1))
						{
							flag.append(STARTED);
							task.setFlag(flag.toString());
						}

						break;
					}
					else
					{
						System.out.println("Dependent task should be started/ended");
						System.exit(0);
					}
				}
			}
		}
	}
}
