package com.vlocity.task.dao.impl;

import com.vlocity.task.dao.PutTaskDao;
import com.vlocity.task.model.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class PutTaskDaoImpl implements PutTaskDao
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  task
	 */
	public void updateTask(List<Task> taskList)
	{
		FileWriter fw;

		try
		{
			fw = new FileWriter("Task.txt", false);
			PrintWriter out = new PrintWriter(fw);
			// Append the name of ocean to the file
			for (Task task : taskList)
			{
				out.println(task.getId() + ";" + task.getTaskName() + ";" + task.getStartDate() + ";"
					+ task.getEndDate() + ";" + task.getDependentTaskId() + ";" + task.getFlag());
			}

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
