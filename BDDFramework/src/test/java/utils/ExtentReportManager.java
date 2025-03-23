package utils;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentSparkReporter sparkReporter;

	// Initialize the report
	public static ExtentReports getReportInstance() {
		if (extent == null) {
			sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Test Execution Report");

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "Sheik");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		return extent;
	}

	// Create a test log
	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	// Flush report at the end of execution
	public static void flushReport() {
	    extent.flush();
	    
	    // Get absolute path of the report
	    String reportPath = new File("test-output/ExtentReport.html").getAbsolutePath();
	    
	    // Check if running in Jenkins
	    if (System.getenv("JENKINS_HOME") == null) {
	        try {
	            // Open report based on OS
	            if (System.getProperty("os.name").toLowerCase().contains("win")) {
	                new ProcessBuilder("cmd.exe", "/c", "start", reportPath).start();
	            } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
	                new ProcessBuilder("open", reportPath).start();
	            } else {
	                new ProcessBuilder("xdg-open", reportPath).start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("Could not open report automatically. Please open it manually: " + reportPath);
	        }
	    } else {
	        // Running in Jenkins, just print the report path
	        System.out.println("Extent Report generated: " + reportPath);
	    }
	}


}
