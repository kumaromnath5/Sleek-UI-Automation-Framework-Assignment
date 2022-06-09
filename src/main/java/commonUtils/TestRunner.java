package commonUtils;


import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author kumar
 * Runner Class
 */

@CucumberOptions(features = "src/test/resource/Features",
        glue = {"com.sleek.stepDefinitions"},dryRun = false, strict = true,
        tags = {"@Sanity"},plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html "})


public class TestRunner extends AbstractTestNGCucumberTests  {


    @AfterSuite
    public static void setup()
    {
   
    }
    
}