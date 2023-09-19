package TestRunner;

import static org.testng.Assert.assertFalse;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/", 
					glue="stepDefinitions", 
					monochrome=false
					//plugin = {"pretty", "html: target/cucumberReports/report.html", "json:target/cucumberReports/report.json"}
					//tags = "@SmokeTest or @Regression"
					//tags = "@background"
				)

public class testrunner extends AbstractTestNGCucumberTests{

}
