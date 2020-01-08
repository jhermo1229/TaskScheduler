package com.vlocity.task.dao.impl;

import com.vlocity.task.Task;
import com.vlocity.task.dao.PostTaskDao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class PostTaskDaoImpl implements PostTaskDao
{
	//~ Methods ----------------------------------
	/** @see  com.vlocity.task.dao.PostTaskDao#AddTask(com.vlocity.task.Task) */
	@Override
	public void saveTask(Task task)
	{
		FileWriter fw;

		try
		{
			fw = new FileWriter("Task.txt", true);
			PrintWriter out = new PrintWriter(fw);
			// Append the name of ocean to the file
			out.println(task.getId() + ";" + task.getTaskName() + ";" + task.getStartDate() + ";" + task.getEndDate()
				+ ";" + task.getDependentTaskId() + ";" + task.getFlag());

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
