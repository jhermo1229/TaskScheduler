package com.vlocity.task.services.impl;

import com.vlocity.task.Task;
import com.vlocity.task.services.RetrieveTasks;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class RetrieveTasksImpl implements RetrieveTasks
{
	//~ Methods ----------------------------------
	/**
	 * @return
	 * @see     RetrieveTasks#getAllTasks()
	 */
	public List<Task> getAllTasks()
	{
		List<Task> taskList = new ArrayList<>();
		File file = new File(("Task.txt"));

		if ((file != null) && file.exists())
		{
			Scanner scanner = null;
			try
			{
				scanner = new Scanner(file);
				// get first line
				// scanner.nextLine();
				while (scanner.hasNextLine())
				{
					String readLine = scanner.nextLine();

					String[] productArr = readLine.split(";");

					if ((productArr != null) && (productArr.length > 0))
					{
						Task task = new Task();
						task.setId(Integer.valueOf(productArr[0]));
						task.setTaskName(productArr[1]);
						task.setStartDate(Integer.valueOf(productArr[2]));
						task.setEndDate(Integer.valueOf(productArr[3]));
						task.setDependentTaskId(Integer.valueOf(productArr[4]));
						taskList.add(task);
					}
				}
			}
			catch (FileNotFoundException fnf)
			{
				fnf.printStackTrace();
			}
			finally
			{
				if (scanner != null)
				{
					scanner.close();
					scanner = null;
				}
			}
		} // end if

		return taskList;
	}
}
