package com.vlocity.task;

/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class Task
{
	//~ Instance fields --------------------------
	/**  */
	Integer dependentTaskId;

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
	public Integer getDependentTaskId()
	{
		return dependentTaskId;
	}
	
	/**
	 * DOCUMENT ME!
	 *
	 * @param  i
	 */
	public void setDependentTaskId(Integer i)
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
