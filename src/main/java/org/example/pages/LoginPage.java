package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static final By userNameBox = By.name("username");
    private static final By passBox = By.name("password");
    private static final By loginButton = By.cssSelector("button[type='submit']");


    public static void logIn(String user, String password,WebDriver driver) {
        WebElement userNameInput = driver.findElement(userNameBox);
        userNameInput.sendKeys(user);
        WebElement passInput = driver.findElement(passBox);
        passInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();

    }

}
