package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private static final By adminModule = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");

    public static void accessAdminModule(WebDriver driver) {
        WebElement adminModule = driver.findElement(DashboardPage.adminModule);
        adminModule.click();
    }

}
