package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.pages.LoginPage.*;

public class Login {


    public static void logIn(String user, String password, WebDriver driver) {
        WebElement userNameInput = driver.findElement(userNameBox);
        userNameInput.sendKeys(user);
        WebElement passInput = driver.findElement(passBox);
        passInput.sendKeys(password);

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();

    }

}
