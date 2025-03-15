package org.example.utils;

import com.aventstack.extentreports.ExtentTest;
import org.example.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AccessToModule {

    public static void adminModule(WebDriver driver, ExtentTest test) throws IOException {
        WebElement adminModule = driver.findElement(DashboardPage.adminModule);
        adminModule.click();
        Validations.validateAdminSection(driver,test);
    }



}
