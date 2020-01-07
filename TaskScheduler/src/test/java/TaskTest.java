import com.vlocity.services.RetrieveTasks;
import com.vlocity.services.impl.RetrieveTasksImpl;

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
