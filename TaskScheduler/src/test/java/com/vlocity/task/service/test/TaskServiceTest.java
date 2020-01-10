package com.vlocity.task.service.test;

import com.vlocity.task.model.Task;
import com.vlocity.task.service.GetTaskService;
import com.vlocity.task.service.PostTaskService;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class TaskServiceTest
{
	//~ Methods ----------------------------------
	/** Test retrieval of task */
	@Test
	public void retrieveTaskTest()
	{
		GetTaskService retrieveTask = new GetTaskService();
		Assert.assertNotNull(retrieveTask.getAllTasks());
	}
	
	/** Test dependency validation */
	@Test
	public void updateTaskTest()
	{
		PostTaskService postTask = new PostTaskService();
		Task task = taskCreation("Sample task 1", 1, 20200101, 20200102, "C", "2");

		List<Task> taskList = new ArrayList<>();
		Task forTask1 = taskCreation("Sample task 2", 2, 20200101, 20200102, "C", "0");
		Task forTask2 = taskCreation("Sample task 3", 3, 20200101, 20200102, "C", "0");
		taskList.add(forTask2);
		taskList.add(forTask1);

		String dependentId = "4";

		Assert.assertFalse(postTask.validateInput(task, taskList, dependentId));
	}
	
	/**
	 * Task creation
	 *
	 * @param   taskName
	 * @param   id
	 * @param   startDate
	 * @param   EndDate
	 * @param   flag
	 * @param   depId
	 * @return
	 */
	private Task taskCreation(String taskName, int id, int startDate,
		int EndDate, String flag, String depId)
	{
		Task task = new Task();
		task.setTaskName(taskName);
		task.setId(id);
		task.setStartDate(startDate);
		task.setEndDate(EndDate);
		task.setFlag(flag);
		task.setDependentTaskId(depId);

		return task;
	}
}
