package com.vlocity.task.services;

import com.vlocity.task.Task;
import com.vlocity.task.dao.PutTaskDao;
import com.vlocity.task.dao.impl.PutTaskDaoImpl;

import com.vlocity.util.TaskSchedulerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class StartTaskService
{
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
			if (!task.getFlag().contains("S"))
			{
				notStartedList.add(task);
			}
		}

		TaskSchedulerUtil.getInstance().printTasks(notStartedList);
		System.out.println("Please choose task ID of task to start:");

		Scanner input = new Scanner(System.in);

		int taskId = input.nextInt();

		for (Task task : taskList)
		{
			if (task.getId() == taskId)
			{
				if (task.getDependentTaskId() > 0)
				{
					for (Task task3 : taskList)
					{
						if (task3.getId() == task.getDependentTaskId())
						{
							if (task3.getFlag().contains("E"))
							{
								String flag = task.getFlag();
								flag.concat("S");
								task.setFlag(flag);

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
				else
				{
					StringBuilder flag = new StringBuilder(task.getFlag());
					flag.append("S");
					task.setFlag(flag.toString());
				}
			}
			finalTaskList.add(task);
		} // end for
		updateTask.updateTask(finalTaskList);
	}
}
