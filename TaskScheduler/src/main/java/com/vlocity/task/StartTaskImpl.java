package com.vlocity.task;

import com.vlocity.task.services.AddTask;
import com.vlocity.task.services.impl.AddTaskImpl;

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
public class StartTaskImpl implements StartTask
{
	//~ Methods ----------------------------------
	/**
	 * @throws  Exception
	 * @see     com.vlocity.task.StartTask#startTask(java.lang.Integer)
	 */
	public void startTask(Integer taskId) throws Exception
	{
		List<Task> taskList = new ArrayList<Task>();
		List<Task> finalTaskList = new ArrayList<>();
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
			} // end try-catch-finally
		} // end if

		for (Task task2 : taskList)
		{
			if (task2.getId() == taskId)
			{
				if (task2.getDependentTaskId() > 0)
				{
					for (Task task3 : taskList)
					{
						if (task3.getId() == task2.getDependentTaskId())
						{
							if (task3.getFlag().contains("E"))
							{
								String flag = task2.getFlag();
								flag.concat("S");
								task2.setFlag(flag);

								break;
							}
							else
							{
								// throw dependent task should be started
								throw new Exception("Dependent task should be started");
							}
						}
					}
				}
				else
				{
					String flag = task2.getFlag();
					flag.concat("S");
					task2.setFlag(flag);
				}
			}
			finalTaskList.add(task2);
		} // end for
		for (Task task : finalTaskList)
		{
			AddTask save = new AddTaskImpl();
			// save.saveTask(task);
		}
	}
}
