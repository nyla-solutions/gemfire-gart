package nyla.solutions.gedi.gemfire.gart.api.cachexml;

import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nyla.solutions.gedi.gemfire.gart.Gart;

/**
 * 
 * @author Gregory Green
 *
 */
public class ServerXmlStep
{

	@Given("^cache xml files:$")
	public void cache_xml_files(List<String> files) throws Throwable
	{
	   Gart.getInstance().constructServerXml(files);
	}//------------------------------------------------

	@Then("^Assert all partitioned region gateway sender ids are parallel$")
	public void assert_all_partitioned_region_gateway_sender_ids_are_parallel() throws Throwable
	{
		
	}

	@Then("^Assert gateway sender enable batch conflation is true$")
	public void assert_gateway_sender_enable_batch_conflation_is_true() throws Throwable
	{
		Gart.getInstance().assertGwConflation();
	}

	@Then("^Assert cache server socket buffer size is set$")
	public void assert_cache_server_socket_buffer_size_is_set() throws Throwable
	{
		throw new PendingException();
	}

	@Then("^Assert disk store auto compact is false$")
	public void assert_disk_store_auto_compact_is_false() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Assert disk store allow force compaction is true$")
	public void assert_disk_store_allow_force_compaction_is_true() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Assert region region attribute statistics enabled is true$")
	public void assert_region_region_attribute_statistics_enabled_is_true() throws Throwable
	{
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}
	
	@Then("^Assert gateway sender socket buffer size is set$")
	public void assert_gateway_sender_socket_buffer_size_is_set() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
