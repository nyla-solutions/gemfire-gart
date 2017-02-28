package nyla.solutions.gedi.gemfire.gart.api.cachexml;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Gregory Green
 *
 */
public class ServerXmlGartTest
{

	/**
	 * Test method for {@link nyla.solutions.gedi.gemfire.gart.api.CacheXmlGart#CacheXmlGart(java.io.File)}.
	 */
	@Test
	public void testCacheXmlGart()
	{
		File file = new File("src/test/resources/cache-xmls/server1.xml");
		
		ServerXmlGart serverXml = new ServerXmlGart(file);
		
		Assert.assertTrue(serverXml.isGatewaySenderParallel("gw_sender_16_1"));
		
		//socket-buffer-size
		Assert.assertTrue(serverXml.hasGatewaySenderSocketBucketSize("gw_sender_16_1"));
		
		Assert.assertFalse(serverXml.hasGatewaySenderSocketBucketSize("invalid"));
		
	}

}
