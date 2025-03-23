package stepdefinitions;

import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utils.DriverConf;
import utils.ExtentReportListener;

public class LoginStepsPOM extends DriverConf{

//	static WebDriver driver;
	WebDriver driver = DriverConf.getDriver(); 
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	private static final Logger logger = Logger.getLogger(WebDriverManager.class.getName());
	ExtentReportListener report = new ExtentReportListener();
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() throws InterruptedException {
		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://www.saucedemo.com/");
//		Thread.sleep(3000);
//		loginPage = new LoginPage(driver);
		System.out.println("Login Page Step Def Filler");
		report.logStepWithScreenshot("User navigated to login page", true);
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_username_and_password(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}
	
	@When("User enters invalid {string} and {string}")
	public void user_enters_invalid_username_and_password(String username,String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
		loginPage.clickLogin();
		logger.info("clicks_on_login_button");
		
	}

	@And("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//		homePage = new HomePage();
		
		homePage.isLogoDisplayed(loginPage);
		homePage.isCartDisplayed();
		
	}
	
	@And("User Should see error message")
	public void user_should_see_error_message() {
		loginPage.checkForErrorMessagePass();
	}

	@Then("Close the browser")
	public void close_the_browser() {
//		driver.quit();
		System.out.println("Close Browser Filler");
	}
}
