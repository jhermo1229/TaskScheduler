package com.vlocity.task.dao;

import com.vlocity.task.model.Task;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public interface PostTaskDao
{
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @param  task
	 */
	void saveTask(Task task);
}
