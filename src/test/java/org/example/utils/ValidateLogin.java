package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateLogin {

    public static void validate(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h6[normalize-space()='Dashboard']")));
        }catch(TimeoutException e)
        {
            System.out.println("It wasn't possible to access");
            driver.quit();
            throw e;

        }

        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h6[normalize-space()='Dashboard']")));
        WebElement loginSuccess = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']"));
        //Check if we are in dashboard
        String loginSuccessText = loginSuccess.getText();
        String expectedMessage = "Dashboard";
        Assert.assertEquals(loginSuccessText, expectedMessage);
    }
}
