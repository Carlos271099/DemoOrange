package org.example.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.example.pages.LoginPage.*;

public class Login {
    /*
    In each class that we need to do or go to something, its always the same, we use our By elements of their own page
    and we do a simple action like do click or fill something
    after do the main action or actions we use another class of validation
    in that class we validate depends on what action we do some validations and take a screenshot
     */

    public static void logIn(String user, String password, WebDriver driver, ExtentTest test) throws IOException {
        //We have to wait until we can see for both user & password inputs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='orangehrm-login-slot']")));

        WebElement userNameInput = driver.findElement(userNameBox);
        userNameInput.sendKeys(user);
        WebElement passInput = driver.findElement(passBox);
        passInput.sendKeys(password);
        Delay.delay(4000);
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        //Validate tha login are correct, and add an information to our test log
        Validations.validateLogin(driver,test);



    }

    /*
    public static String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

     */

}
