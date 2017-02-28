package nyla.solutions.gedi.gemfire.gart.api.cachexml;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import nyla.solutions.core.exception.SystemException;
import nyla.solutions.core.io.IO;
import nyla.solutions.core.util.Config;
import nyla.solutions.xml.DOM4J;


public class ServerXmlGart
{
	public ServerXmlGart(File file)
	{
		try
		{
			//look files
			this.document = DOM4J.toDocument(IO.readFile(file));
		}
		catch (Exception e)
		{
			throw new SystemException("Unable to process file:"+file+" error:"+e.getMessage(),e);
		}
		
	}//------------------------------------------------
	public boolean isGatewaySenderParallel(String gatewaySenderID)
	{
		return "true".equals(String.valueOf(getAttributeBoolById(gatewaySenderID,"parallel", false)));
	}//------------------------------------------------
	/**
	 * 
	 * @param gatewaySenderID the gateway Sender ID
	 * @return true if socket bucket size is set
	 */
	public boolean hasGatewaySenderSocketBucketSize(String gatewaySenderID)
	{
		String socketBucketSize = getAttributeById(gatewaySenderID,"socket-buffer-size");
		return socketBucketSize != null && socketBucketSize.trim().length() > 0;
		
	}//------------------------------------------------
	
	public boolean isGatewaySenderEnableBatchConflation(String gatewaySenderID)
	{
		return "true".equals(String.valueOf(getAttributeBoolById(gatewaySenderID,"enable-batch-conflation", false)));
	}//------------------------------------------------
	
	private boolean getAttributeBoolById(String gatewaySenderID, String attribute, boolean defaultBool)
	{
		String text = getAttributeById(gatewaySenderID,attribute);
		
		if(text == null)
			return defaultBool;
		
		return "true".equalsIgnoreCase(text);
	}//------------------------------------------------
	private String getAttributeById(String id,String attribute)
	{
		Element element = (Element)this.document.selectSingleNode("//*[@id='"+id+"']");
		if(element == null)
			return null;
		
		Attribute parallel = element.attribute(attribute);
		if(parallel == null)
			return null;
		
		return parallel.getText();
	}//------------------------------------------------
	@SuppressWarnings("unchecked")
	public Set<String> getGatewaySenderIds()
	{
		
		List<Element> attributes = this.document.selectNodes("//gateway-sender[@id]");
		
		if(attributes == null || attributes.isEmpty())
			return null;
		
		HashSet<String> ids = new HashSet<String>();
		for (Element attribute : attributes)
		{
			ids.add(attribute.attributeValue("id"));
		}
		
		return ids;
	}//------------------------------------------------
	public synchronized static ServerXmlGart getInstance()
	{
		if(gart == null)
			gart = new ServerXmlGart(new File(Config.getProperty("gart.file")));
		
		return gart;
	}//------------------------------------------------
	
	private final Document document;
	private static ServerXmlGart gart = null;
}
