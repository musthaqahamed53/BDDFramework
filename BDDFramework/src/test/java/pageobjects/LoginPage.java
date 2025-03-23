package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.DriverConf;

public class LoginPage {
	
	WebDriver driver;
	By usernameLoc = By.xpath("//input[@id='user-name']");
	By passwordLoc = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtnElem;

	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMessage;

	@FindBy(xpath = "//div[@class='login_logo']")
	public WebElement loginLogo;

	public LoginPage() {
		this.driver = DriverConf.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		driver.findElement(usernameLoc).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLoc).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public void userLogin(String username, String password) {
		driver.findElement(usernameLoc).sendKeys(username);
		driver.findElement(passwordLoc).sendKeys(password);
//		driver.findElement(loginBtn).click();
		loginBtnElem.click();

	}

	public void checkForErrorMessage() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
			wait.until(ExpectedConditions.visibilityOf(errorMessage));
			String textError = errorMessage.getText();
			driver.quit();
			System.out.println(textError);
			Assert.fail(textError);
		} catch (TimeoutException e) {
			System.out.println("No Error Message Displayed");
		}

	}

	public void checkForErrorMessagePass() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(100));
			wait.until(ExpectedConditions.visibilityOf(errorMessage));
			String textError = errorMessage.getText();
			System.out.println(textError);
		} catch (TimeoutException e) {
			System.out.println("No Error Message Displayed");
			Assert.fail("No Error Message Displayed");
		}

	}

}
