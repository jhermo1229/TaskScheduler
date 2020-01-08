package com.vlocity.task.services;

import com.vlocity.task.Task;
import com.vlocity.task.dao.PostTaskDao;
import com.vlocity.task.dao.impl.PostTaskDaoImpl;

import com.vlocity.util.TaskSchedulerUtil;

import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class PostTaskService
{
	//~ Instance fields --------------------------
	/**  */
	private PostTaskDao postTask = new PostTaskDaoImpl();
	//~ Methods ----------------------------------
	/** DOCUMENT ME! */
	@SuppressWarnings("resource")
	public void createTask()
	{
		Task task = new Task();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Task Name: ");
		task.setTaskName(s.nextLine());
		System.out.println("Enter start date (YYYYmmdd): ");
		task.setStartDate(s.nextInt());
		System.out.println("Enter end date (YYYYmmdd): ");
		task.setEndDate(s.nextInt());
		System.out.println("Any task dependency? (Y/N): ");
		String dependency = s.next();
		GetTaskService getTask = new GetTaskService();
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
		task.setFlag("C");

		postTask.saveTask(task);
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
}
