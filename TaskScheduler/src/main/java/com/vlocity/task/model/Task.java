package com.vlocity.task.model;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class Task
{
	//~ Instance fields --------------------------
	/**  */
	String dependentTaskId;

	/**  */
	Integer endDate;

	/**  */
	String flag;

	/**  */
	Integer id;

	/**  */
	Integer startDate;

	/**  */
	String taskName;
	//~ Methods ----------------------------------
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Integer getEndDate()
	{
		return endDate;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  endDate
	 */
	public void setEndDate(Integer endDate)
	{
		this.endDate = endDate;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Integer getStartDate()
	{
		return startDate;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  startDate
	 */
	public void setStartDate(Integer startDate)
	{
		this.startDate = startDate;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getTaskName()
	{
		return taskName;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  taskName
	 */
	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getDependentTaskId()
	{
		return dependentTaskId;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  i
	 */
	public void setDependentTaskId(String i)
	{
		this.dependentTaskId = i;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public Integer getId()
	{
		return id;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  id
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @return
	 */
	public String getFlag()
	{
		return flag;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  flag
	 */
	public void setFlag(String flag)
	{
		this.flag = flag;
	}
}
