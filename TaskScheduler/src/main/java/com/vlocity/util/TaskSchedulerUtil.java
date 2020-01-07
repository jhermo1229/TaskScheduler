package com.vlocity.util;

import com.vlocity.task.Task;

import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public final class TaskSchedulerUtil
{
	//~ Constructors -----------------------------
	/** Creates a new TaskSchedulerUtil object. */
	public TaskSchedulerUtil( ) { }
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public static TaskSchedulerUtil getInstance()
	{
		return TaskSchedulerUtilHolder.INSTANCE;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  taskList
	 */
	public void printTasks(List<Task> taskList)
	{
		System.out.println("Id || Task Name || Start Date || End Date || Task Dependent Id");
		for (Task task : taskList)
		{
			System.out.println(task.getId() + " || " + task.getTaskName() + " || " + task.getStartDate() + " || "
				+ task.getEndDate() + " || " + task.getDependentTaskId());
		}
	}
	//~ Inner Classes ----------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @version  $Revision$, $Date$
	 */
	private static class TaskSchedulerUtilHolder
	{
		/**  */
		private static final TaskSchedulerUtil INSTANCE = new TaskSchedulerUtil();
	}
}
