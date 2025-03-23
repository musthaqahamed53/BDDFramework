package utils;

import java.util.logging.Logger;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConf {

	private static final ThreadLocal<RemoteWebDriver> threadDriver = new ThreadLocal<>();
	private static final Logger logger = Logger.getLogger(WebDriverManager.class.getName());

	public static RemoteWebDriver getDriver() {
		return threadDriver.get();
	}

	public void invokeBrowser() {
		String browser = "chrome";
		RemoteWebDriver driver;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("The browser " + browser + " is not supported.");
		}
		
		
		threadDriver.set(driver);
		getDriver().manage().window().maximize();
		logger.info("Browser initialized successfully: " + browser);
		
	}
	
	public void closeBrowser() {
		if(getDriver() != null) {
			getDriver().quit();
			threadDriver.remove();
//			System.out.println("Browser is closed");
		}
	}

}
