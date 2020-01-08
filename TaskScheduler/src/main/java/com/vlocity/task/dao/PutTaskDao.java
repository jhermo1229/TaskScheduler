package com.vlocity.task.dao;

import com.vlocity.task.Task;

import java.util.List;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public interface PutTaskDao
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  taskList
	 */
	void updateTask(List<Task> task);
}
