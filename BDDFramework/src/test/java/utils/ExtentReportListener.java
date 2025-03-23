package utils;


import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Scenario;

public class ExtentReportListener {
    private static ExtentReports extent = ExtentReportManager.getReportInstance();
    private static ExtentTest test;

    public void setup(Scenario scenario) {
        test = extent.createTest(scenario.getName()); // Create a test for each scenario
    }

    public void logStep(String stepDescription, boolean isPassed) {
        if (isPassed) {
            test.log(Status.PASS, stepDescription);
        } else {
            test.log(Status.FAIL, stepDescription);
        }
    }
    
    public void logStepWithScreenshot(String stepDescription, boolean isPassed) {
        
    	String screenshotPath = ScreenshotUtil.captureScreenshot(DriverConf.getDriver(), stepDescription.replace(" ", "_"));
        
    	File screenshotFile = new File(screenshotPath);
        String absolutePath = screenshotFile.getAbsolutePath();
    	
        if (isPassed) {
            test.log(Status.PASS, stepDescription,
                    MediaEntityBuilder.createScreenCaptureFromPath(absolutePath).build());
        } else {
            test.log(Status.FAIL, stepDescription,
                    MediaEntityBuilder.createScreenCaptureFromPath(absolutePath).build());
        }
    }


    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }
        ExtentReportManager.flushReport();
    }
}
