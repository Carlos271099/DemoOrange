package org.example.utils;

import com.aventstack.extentreports.ExtentTest;
import org.example.pages.SaveSystemUser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AddNewUserEmployee {

    public static void addNew(WebDriver driver, ExtentTest test) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement roleSelect = driver.findElement(SaveSystemUser.userRoleSelect);
        WebElement roleStatus = driver.findElement(SaveSystemUser.status);

        WebElement employeeUserBox = driver.findElement(SaveSystemUser.userNameBox);
        employeeUserBox.sendKeys(ReadProperties.getEmployeeUser());
        Delay.delay(3000);
        Validations.validateUserName(driver,test);

        WebElement employeePassBox = driver.findElement(SaveSystemUser.employeePass);
        employeePassBox.sendKeys(ReadProperties.getEmployeePass());

        WebElement employeeConfirmPassBox = driver.findElement(SaveSystemUser.confirmPass);
        employeeConfirmPassBox.sendKeys(ReadProperties.getEmployeePass());





        roleSelect.click();



        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SaveSystemUser.userRoleOption));

        }catch(TimeoutException e)
        {
            System.out.println("Error");
            throw e;
        }

        WebElement selectOption = driver.findElement(SaveSystemUser.userRoleOption);
        selectOption.click();

        roleStatus.click();
        WebElement selectStatus = driver.findElement(SaveSystemUser.statusEnabled);
        selectStatus.click();


        WebElement employeeNameBox = driver.findElement(SaveSystemUser.employeeNameBox);
        employeeNameBox.sendKeys(ReadProperties.getEmployeeName());



        Validations.validateEmployeeExists(driver,test);

        WebElement employeeFullName = driver.findElement(SaveSystemUser.selectName);
        wait.until(ExpectedConditions.visibilityOf(employeeFullName));


        employeeFullName.click();

        WebElement saveButton = driver.findElement(SaveSystemUser.saveButton);
        saveButton.click();


        Delay.delay(10000);

        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");


        Validations.validateUsersTable(driver,test);
        Validations.validateUserAdded(driver,test);







    }
}
