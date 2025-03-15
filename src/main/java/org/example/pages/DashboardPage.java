package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    public static final By adminModule = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    public static final By moduleTitle = By.xpath("//h6[normalize-space()='Dashboard']");

    public static final By usersOption = By.className("oxd-userdropdown");
    public static final By logoutOption = By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]");

}
