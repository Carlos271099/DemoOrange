package org.example.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.example.pages.AdminUserManagementPage;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.pages.SaveSystemUser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Validations {

    /*
    This class it helps us to do validations
    almost validations have the same structure, so i did a method to use in each validation and save some code lines
    validation main method also has a way to take a screenshot, and if it fails some validations,
    it goes to Listener class, and do their respective actions..
     */


    public static void validateLogin(WebDriver driver,ExtentTest test) throws IOException {
        Delay.delay(4000);
        validation(driver,DashboardPage.moduleTitle,
                "User or Password are Incorrect","Login Validated",test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    public static void validateAdminSection(WebDriver driver,ExtentTest test) throws IOException {
        validation(driver,AdminUserManagementPage.moduleTitle,
                "Failed attempt to access admin module","Admin Section Validated",test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static void validateAddUserSubModule(WebDriver driver,ExtentTest test) throws IOException {
        validation(driver, SaveSystemUser.subModuleTitle,
                "Failed attempt to access add User subModule","add User subModule Validated",test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static void validateUsersTable(WebDriver driver,ExtentTest test) throws IOException {
        validation(driver,SaveSystemUser.usersTable,
                "It wasn't possible to find users table","users table found it",test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static void validateUserAdded(WebDriver driver,ExtentTest test) throws IOException {
        validation(driver,SaveSystemUser.userName,
                "User Not Saved","User Saved Successfully",test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    //This method is just exclusive to that validation!!!!!!
    public static void validateUserName(WebDriver driver,ExtentTest test) throws IOException {

        //We need to enclose in a try catch structure this validation
        //If it finds that element means that there's a problem with username, maybe already exists, or it's less than 5 characters
        //So if doesn't find it, means that username is right so this validation is true.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SaveSystemUser.userNameError));
            if(driver.findElement(SaveSystemUser.userNameError).isDisplayed()){
                test.fail("UserName already exists or UserName less than 5 characters");
                throw new Error("UserName already exists or UserName less than 5 characters");

            }
        }catch(TimeoutException e)
        {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("reports/userNameValidated.png");
            try{
                FileUtils.copyFile(srcFile, destFile);
            }catch(IOException ee)
            {
                ee.printStackTrace();
            }

            test.log(Status.INFO, "UserName Validated", MediaEntityBuilder.createScreenCaptureFromPath(destFile.getAbsolutePath()).build());

        }


    }

    public static void validateEmployeeExists(WebDriver driver,ExtentTest test) throws IOException {

        validation(driver,SaveSystemUser.selectName,
                "It wasn't possible to find that Employee " +
                        "We were expecting this employee " + ReadProperties.getEmployeeFullName(),
                "Employee Found " + ReadProperties.getEmployeeFullName(),test,
                Thread.currentThread().getStackTrace()[1].getMethodName());
    }


    public static void validateLogout(WebDriver driver,ExtentTest test) throws IOException {
        validation(driver, LoginPage.loginButton,
                "It wasn't possible to logout or you're already are",
                "Logged Out Successfully",
                test,Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static void validation(WebDriver driver, By locator, String error, String success, ExtentTest test,String validation) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        }catch(TimeoutException e)
        {
            System.out.println(error);
            test.fail(error);

            throw e;
        }
        System.out.println(success);
        //test.log(Status.INFO, success);



        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("reports/" + validation + ".png");
        try{
            FileUtils.copyFile(srcFile, destFile);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        test.log(Status.INFO, success, MediaEntityBuilder.createScreenCaptureFromPath(destFile.getAbsolutePath()).build());

    }

}
