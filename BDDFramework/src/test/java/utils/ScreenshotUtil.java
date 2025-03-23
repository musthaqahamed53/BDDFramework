package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	public static String captureScreenshot2(WebDriver driver, String screenshotName) {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = "screenshots/" + screenshotName + "_" + timestamp + ".png";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
	    // Generate timestamp to avoid overwriting
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    
	    // Define screenshot directory
	    String screenshotDir = "test-output/screenshots/";
	    
	    // Ensure the directory exists
	    try {
	        Files.createDirectories(Paths.get(screenshotDir));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Full screenshot path
	    String filePath = screenshotDir + screenshotName + "_" + timestamp + ".png";
	    
	    // Take screenshot
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File destFile = new File(filePath);

	    try {
	        FileUtils.copyFile(srcFile, destFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    // Return absolute path for Extent Reports
	    return destFile.getAbsolutePath();
	}
}