package com.vlocity.task.dao.impl;

import java.io.File;

import com.vlocity.task.dao.GetTaskDao;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class GetTaskDaoImpl implements GetTaskDao
{
	//~ Methods ----------------------------------
	/** @see  com.vlocity.task.dao.GetTaskDao#getAllTask() */
	@Override
	public File getAllTask()
	{
		File file = new File(("Task.txt"));

		return file;
	}
}
