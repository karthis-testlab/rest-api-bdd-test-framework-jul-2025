package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/incident.feature"},
		          glue = {"steps.base.som"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-reports/result.html",
		        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
		          },
		          publish = true,
		          tags = ""
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}