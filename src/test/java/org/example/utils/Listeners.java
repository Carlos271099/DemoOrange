package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.example.resources.ExtentReporterNG;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Listeners implements ITestListener {

    /*
    This one is one of the most important classes with listeners we can do some things easily for our test
    like if one test fails no matter what step it comes here and document that fail and take a screenshot
    this one is from a udemy course this method to take screenshot, and it is different of that takeScreenshot method in validation class
     */

    public static ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();


    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        WebDriver driver;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        String filePath;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

}
