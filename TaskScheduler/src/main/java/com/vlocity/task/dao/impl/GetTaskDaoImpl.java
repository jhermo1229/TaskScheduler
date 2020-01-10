package com.vlocity.task.dao.impl;

import com.vlocity.task.dao.GetTaskDao;

import java.io.File;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class GetTaskDaoImpl implements GetTaskDao
{
	//~ Methods ----------------------------------
	/** @see  com.vlocity.task.dao.GetTaskDao#getAllTask() */
	public File getAllTask()
	{
		File file = new File(("Task.txt"));

		return file;
	}
}
