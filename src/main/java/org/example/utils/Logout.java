package org.example.utils;

import org.example.pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {

    public static void logout(WebDriver driver ) {
        WebElement userOptions = driver.findElement(DashboardPage.usersOption);
        userOptions.click();
        WebElement logout = driver.findElement(DashboardPage.logoutOption);
        logout.click();
    }

}
