package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.LoginPage;
import utils.DriverConf;
import utils.ExtentReportListener;
import utils.ScreenshotUtil;

public class Hooks {
	DriverConf driverConf = new DriverConf();
	LoginPage loginPage;
	WebDriver driver;
	ExtentReportListener reportListener = new ExtentReportListener();
	
	@Before
	public void invokeURL(Scenario scenario) {
		reportListener.setup(scenario);
		reportListener.logStep("Starting Scenario: " + scenario.getName(), true);
		
		driverConf.invokeBrowser();
		driver = DriverConf.getDriver();
		String url = "https://www.saucedemo.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		loginPage = new LoginPage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.loginLogo));
		
		reportListener.logStep("Application launched successfully: Sauce Demo", true);
		System.out.println("Successfully launched the application: Sauce Demo");
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
//            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            reportListener.logStepWithScreenshot(scenario.getName()+" failed. Screenshot attached:", false);
        } else {
            reportListener.logStep("Scenario Passed: " + scenario.getName(), true);
        }
		
		driverConf.closeBrowser();
		System.out.println("Browser closed successfully");
	}
}
