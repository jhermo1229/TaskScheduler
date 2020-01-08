package com.vlocity.task.services;

import com.vlocity.task.Task;
import com.vlocity.task.dao.GetTaskDao;
import com.vlocity.task.dao.impl.GetTaskDaoImpl;

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
public class GetTaskService
{
	//~ Instance fields --------------------------
	/**  */
	private GetTaskDao getTaskDao = new GetTaskDaoImpl();
	//~ Methods ----------------------------------
	/**
	 * @return
	 * @see     RetrieveTasks#getAllTasks()
	 */
	public List<Task> getAllTasks()
	{
		File file = getTaskDao.getAllTask();
		List<Task> taskList = new ArrayList<>();
		if ((file != null) && file.exists())
		{
			Scanner scanner = null;
			try
			{
				scanner = new Scanner(file);

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
						task.setFlag(productArr[5]);
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
