package com.vlocity.services.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.vlocity.services.AddTask;

import main.java.Task;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class AddTaskImpl implements AddTask
{
	//~ Methods ----------------------------------
	/** @see  com.vlocity.services.AddTask#saveTask(main.java.Task) */
	@Override
	public void saveTask(Task task)
	{
		// Open the file in append mode.
		FileWriter fw;

		try
		{
			fw = new FileWriter("Task.txt", true);
			PrintWriter out = new PrintWriter(fw);
			// Append the name of ocean to the file
			out.println(task.getId() + ";" + task.getTaskName() + ";" + task.getStartDate() + ";" + task.getEndDate()
				+ ";" + task.getDependentTaskId());

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
