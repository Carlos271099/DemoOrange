package org.example.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    //This class just contains web driver
    //in this way we don't need to write it on each page

    private final WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


}
