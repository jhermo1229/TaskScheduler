package main.java;

import com.vlocity.services.AddTask;
import com.vlocity.services.RetrieveTasks;
import com.vlocity.services.impl.AddTaskImpl;
import com.vlocity.services.impl.RetrieveTasksImpl;

import java.util.List;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class ApplicationRunner
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  args
	 */
	public static void main(String[] args)
	{
		System.out.print("Choose task todo: [G]et all task :");
		Scanner s = new Scanner(System.in);
		String ss = s.next();

		if (ss.equalsIgnoreCase("C"))
		{
			createNewTask();
		}
		else if (ss.equalsIgnoreCase("G"))
		{
			RetrieveTasks getTask = new RetrieveTasksImpl();
			getTask.getAllTasks();
		}
		else if (ss.equalsIgnoreCase("R"))
		{
			runTask();
		}
	}
	
	/** DOCUMENT ME! */
	private static void runTask()
	{
		// TODO Auto-generated method stub
	}
	
	/** DOCUMENT ME! */
	private static void createNewTask()
	{
		Task task = new Task();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Task Name: ");
		task.setTaskName(s.nextLine());
		System.out.println("Enter start date (YYYYmmdd): ");
		task.setStartDate(s.nextInt());
		System.out.println("Enter end date (YYYYmmdd): ");
		task.setEndDate(s.nextInt());
		System.out.println("Any task dependency?: ");
		String sss = s.next();
		RetrieveTasks getTask = new RetrieveTasksImpl();
		List<Task> taskList = getTask.getAllTasks();
		if (sss.equalsIgnoreCase("Y"))
		{
			System.out.println("Please choose task ID of dependent task:");
			System.out.println("Id || Task Name || Start Date || End Date");
			for (Task tasks : taskList)
			{
				System.out.println(tasks.getId() + " || " + tasks.getTaskName() + " || " + tasks.getStartDate() + " || "
					+ tasks.getEndDate());
			}

			System.out.println("Task id of dependent task:");
			task.setDependentTaskId(s.nextInt());
		}
		task.setId(taskList.size() + 1);
		saveTask(task);
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  task
	 */
	private static void saveTask(Task task)
	{
		AddTask save = new AddTaskImpl();
		save.saveTask(task);
	}
}
