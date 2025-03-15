package org.example.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    /*
    This is a base extent report we just set up our path to save this report and other basic things
     */
    public static ExtentReports getReportObject(){
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Orange Web Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Carlos-Hexaware");
        extent.createTest(path);
        return extent;

    }




}
