package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@SmokeTest or @Valid or @Invalid", 
		features = { "src/test/resources/Features/login.feature" }, 
		glue = {"stepdefinitions" , "hooks"}, 
		plugin = {"pretty","html:target/htmlreport.html"}
		)

public class CucumberRunner extends AbstractTestNGCucumberTests{

}
