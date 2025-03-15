package org.example;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AppTest{

    public static WebDriver driver = new FirefoxDriver();

    @Test(description = "Test for create a new user employee using admin account")
    public void CreateUserEmployee() throws IOException {
    //This test we just call those methods validations and other stuff are inside those methods.
    //Remember, to execute this test we need to execute "testng.xml" located in a package
        //called "testSuites" and reports are stored in a folder called reports inside of the project this
        //later gonna be moved outside of the project.

        //Go to test page
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

        //Read & Obtain user & pass from config.properties
        String user = ReadProperties.getUserNameAdmin();
        String pass = ReadProperties.getUserPassAdmin();

        //Use method logIn to access
        Login.logIn(user,pass,driver,Listeners.test);

        //Access to admin Module
        AccessToModule.adminModule(driver,Listeners.test);

        //Access to submodule add system user
        AccessToSubModule.addSystemUser(driver,Listeners.test);

        Delay.delay(3000);
        AddNewUserEmployee.addNew(driver,Listeners.test);

        Delay.delay(5000);

        //Logout after finish test
        Logout.logout(driver);
        //validate that we are out of that page
        Validations.validateLogout(driver,Listeners.test);


    }



    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
