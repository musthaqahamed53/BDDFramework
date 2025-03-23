package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageobjects.LoginPage;
import utils.DriverConf;

public class Hooks {
	DriverConf driverConf = new DriverConf();
	LoginPage loginPage;
	WebDriver driver;
	@Before
	public void invokeURL() {
		
		driverConf.invokeBrowser();
		driver = DriverConf.getDriver();
		String url = "https://www.saucedemo.com";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		loginPage = new LoginPage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginPage.loginLogo));
		System.out.println("Successfully launched the application: Sauce Demo");
		
	}
	
	@After
	public void tearDown() {
		driverConf.closeBrowser();
		System.out.println("Browser closed successfully");
	}
}
