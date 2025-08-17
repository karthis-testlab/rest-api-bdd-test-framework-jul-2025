package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/incident.feature"},
		          glue = {"step_definitions"},
		          dryRun = false,
		          plugin = {
		        		  "html:cucumber-reports/result.html",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		          },
		          publish = true,
		          tags = "not @regression"
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}