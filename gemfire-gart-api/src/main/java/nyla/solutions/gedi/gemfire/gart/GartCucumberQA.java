package nyla.solutions.gedi.gemfire.gart;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/resources/gemfire/gemfire.cache.xml.feature"}, 
plugin = {"pretty", "json:target/cucumber-report.json", 
		"html:target/cucumber-reports.html"},strict =true)
public class GartCucumberQA
extends TestCase
{
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GartCucumberQA.class );
    }

}
