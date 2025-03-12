package org.example.utils;

import org.example.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccessToModule {

    public static void adminModule(WebDriver driver) {
        WebElement adminModule = driver.findElement(DashboardPage.adminModule);
        adminModule.click();
    }



}
