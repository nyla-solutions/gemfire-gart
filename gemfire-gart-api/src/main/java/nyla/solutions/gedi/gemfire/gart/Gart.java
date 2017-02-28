package nyla.solutions.gedi.gemfire.gart;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import nyla.solutions.gedi.gemfire.gart.api.cachexml.ServerXmlGart;
import nyla.solutions.gedi.gemfire.gart.exception.GartWarningException;

public class Gart
{
	/**
	 * 
	 * @param files the server XML files
	 */
	public void constructServerXml(Collection<String> files)
	{
		if(files == null || files.isEmpty())
			return;
		
		for (String file : files)
		{
			if(serverXmlGartMap.containsKey(file))
				continue;
			
			serverXmlGartMap.put(file, new ServerXmlGart(new File(file)));
		}
			
	}//------------------------------------------------
	/**
	 * Assert gateway has batch conflation enabled
	 */
	public void assertGwConflation()
	{
		for(Map.Entry<String, ServerXmlGart> entry : this.serverXmlGartMap.entrySet())
		{
			Set<String> ids = entry.getValue().getGatewaySenderIds();
			
			if(ids == null)
				continue;
			
			for (String id : ids)
			{
				if(!entry.getValue().isGatewaySenderEnableBatchConflation(id))
					throw new GartWarningException("Gateway sender id:"+id+" does not have sender enabled batch conflation in file:"+entry.getKey());
			}
		}
	}//------------------------------------------------
	/**
	 * Check whether all gateway senders have the socket buffer size set
	 */
	public void assertGwSenderHasSocketBuffetSize()
	{
		for(Map.Entry<String, ServerXmlGart> entry : this.serverXmlGartMap.entrySet())
		{
			Set<String> ids = entry.getValue().getGatewaySenderIds();
			
			if(ids == null)
				continue;
			
			for (String id : ids)
			{
				if(!entry.getValue().hasGatewaySenderSocketBucketSize(id))
					throw new GartWarningException("Gateway sender id:"+id+" does not set the socket-bucket-size file:"+entry.getKey());
			}
		}
	}//------------------------------------------------
	
	
	
	
	
	public static Gart getInstance()
	{
		return gart;
	}//------------------------------------------------

	private Map<String, ServerXmlGart> serverXmlGartMap = new ConcurrentHashMap<String, ServerXmlGart>();
	private static Gart gart = new Gart();
}
