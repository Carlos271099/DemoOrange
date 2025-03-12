package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static final By userNameBox = By.name("username");
    public static final By passBox = By.name("password");
    public static final By loginButton = By.cssSelector("button[type='submit']");

}
