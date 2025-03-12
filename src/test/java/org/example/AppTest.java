package org.example;


import org.example.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AppTest{

    @Test(description = "Test for create a new user employee using admin account")
    public void CreateUserEmployee() throws IOException {

        //Create a new Instance of WebDriver
        WebDriver driver = new FirefoxDriver();
        //Go to test page
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        //We have to wait until we can see for both user & password inputs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='orangehrm-login-slot']")));


        //Read & Obtain user & pass from config.properties
        String user = ReadProperties.getUserName();
        String pass = ReadProperties.getUserPass();
        //Use method logIn to access
        Login.logIn(user,pass,driver);
        //Method to validate a successful login
        ValidateLogin.validate(driver);
        //Access to admin Module
        AccessToModule.adminModule(driver);
        //Access to submodule add system user
        AccessToSubModule.addSystemUser(driver);
        try {
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();

    }

}
