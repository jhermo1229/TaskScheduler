
import com.vlocity.task.services.GetTaskService;

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
		GetTaskService retrieveTask = new GetTaskService();
		Assert.assertNotNull(retrieveTask.getAllTasks());
	}
}
