package com.vlocity.task.dao;

import java.util.List;

import com.vlocity.task.model.Task;


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
