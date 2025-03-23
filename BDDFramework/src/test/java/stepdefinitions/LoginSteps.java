//package stepdefinitions;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginSteps {
//
//	static WebDriver driver;
//
//	@Given("User is on Login Page")
//	public void user_is_on_login_page() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get("https://www.saucedemo.com/");
//		Thread.sleep(3000);
//	}
//
//	@When("User enters valid {string} and {string}")
//	public void user_enters_valid_username_and_password(String username,String password) {
//		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
//
//	}
//
//	@And("Clicks on Login Button")
//	public void clicks_on_login_button() {
//		driver.findElement(By.xpath("//input[@id='login-button']")).click();
//	}
//
//	@And("User is navigated to Home Page")
//	public void user_is_navigated_to_home_page() {
//		driver.getTitle();
//		List<WebElement> page_logo_text = driver.findElements(By.xpath("//div[@class='app_logo']"));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		Assert.assertTrue(page_logo_text.size() > 0, "User Navigated to Home Page");
//		
//	}
//
//	@Then("Close the browser")
//	public void close_the_browser() {
//		driver.quit();
//	}
//}
