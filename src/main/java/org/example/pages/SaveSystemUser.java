package org.example.pages;

import org.example.utils.ReadProperties;
import org.openqa.selenium.By;

import java.io.IOException;

public class SaveSystemUser {
    public static final By subModuleTitle = By.xpath("//h6[normalize-space()='Add User']");
    public static final By employeeNameBox = By.xpath("//input[@placeholder='Type for hints...']");
    public static final By userNameBox = By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    public static final By employeePass = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    public static final By confirmPass = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    public static final By saveButton = By.xpath("//button[normalize-space()='Save']");


    public static final By userRoleSelect = By.xpath("((//div[@class='oxd-select-text oxd-select-text--active'])[1])");
    public static final By userRoleOption = By.xpath("//span[text()='ESS']");
    public static final By status = By.xpath("(//*[@class='oxd-select-text-input'])[2]");
    public static final By statusEnabled = By.xpath("//span[text()='Enabled']");

    public static final By selectName;
    public static final By usersTable = By.xpath("//div[@class='orangehrm-container']");
    public static final By userNameError = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    public static final By userName;


    static {
        try {
            userName = By.xpath("//div[contains(text(),'" + ReadProperties.getEmployeeUser() + "')]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            selectName = By.xpath("//span[text()='" + ReadProperties.getEmployeeFullName() + "'" + "]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
