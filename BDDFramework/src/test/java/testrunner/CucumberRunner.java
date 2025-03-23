package testrunner;

import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReportManager;

@CucumberOptions(
        tags = "@SmokeTest or @Valid or @Invalid",
        features = {"src/test/resources/Features/login.feature"},
        glue = {"stepdefinitions", "hooks", "utils"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
	@AfterClass
    public static void tearDown() {
        ExtentReportManager.flushReport(); // ✅ Ensures Extent Reports are properly generated after tests
    }
}
