package org.example;


import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.ReadProperties;
import org.example.utils.ValidateLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class AppTest{

    @Test(description = "First test for create a new user employee using admin account")
    public void CreateUserEmployee() throws IOException {

        //Create a new Instance of WebDriver
        WebDriver driver = new FirefoxDriver();
        //Go to test page
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        //We have to wait until we can see for both user & password inputs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='orangehrm-login-slot']")));

        //Use method logIn to access
            //String user = ReadProperties.getUserApp();

            //String pass = ReadProperties.getUserPass();

        LoginPage.logIn("Admin","admin123",driver);
        //Method to validate a successful login
        ValidateLogin.validate(driver);
        //Access to admin Module
        DashboardPage.accessAdminModule(driver);

        driver.quit();

    }

}
