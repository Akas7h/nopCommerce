package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



	@RunWith(Cucumber.class)
	@CucumberOptions(
			
			features="src/test/java/Features",
			glue= {"stepDefinitions"},
			//publish=true,
			plugin = {"pretty",
					
					"json:target/jsonReports/cucumber-report.json",
					
			},
			strict=true,
			dryRun=true,
			monochrome = true,
			//@dev,@wip
		    tags = {"@sanity or @regression"}
			
			
		)	
	
	public class TestRunner {

	}

	

