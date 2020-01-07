import com.vlocity.task.services.RetrieveTasks;
import com.vlocity.task.services.impl.RetrieveTasksImpl;

import org.junit.Assert;
import org.junit.Test;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class TaskTest
{
	//~ Methods ----------------------------------
	/** DOCUMENT ME! */
	@Test
	public void retrieveTaskTest()
	{
		RetrieveTasks retrieveTask = new RetrieveTasksImpl();
		Assert.assertNotNull(retrieveTask.getAllTasks());
	}
}
