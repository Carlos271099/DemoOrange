package org.example.utils;

import org.example.pages.AdminUserManagementPage;
import org.example.pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.pages.AdminUserManagementPage.addSystemUser;

public class AccessToSubModule {

    public static void addSystemUser (WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addSystemUser));
        WebElement addSystemUser = driver.findElement(AdminUserManagementPage.addSystemUser);

        addSystemUser.click();

    }

}
