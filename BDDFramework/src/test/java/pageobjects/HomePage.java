package pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	By label_logo = By.xpath("//div[@class='app_logo']");

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement logo_elem;

	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	WebElement cartElem;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void isLogoDisplayed(LoginPage loginPage) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(logo_elem));
			System.out.println("HomePage appeared within the given time.");
			Assert.assertTrue(logo_elem.isDisplayed());
		} catch (TimeoutException e) {
			System.out.println("HomePage did not appear within the given time.");
			loginPage.checkForErrorMessage();
			Assert.fail("HomePage did not appear within the given time.");
		}

	}
	
	public void isCartDisplayed() {
		cartElem.isDisplayed();
	}

}
