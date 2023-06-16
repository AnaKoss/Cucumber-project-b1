package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     *Logins to the docuport application
     * @param driver, which initialized in test base
     * @param role, comes from docuport constants
     * @autor Ana
     */

    public static void login(WebDriver driver, String role){   //without static we need to create object

            Driver.getDriver().get(ConfigurationReader.getProperty("env"));
            WebElement username = Driver.getDriver().findElement(By.xpath("//label[.='Username or email']"));
            WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='input-15']"));
            WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        switch(role.toLowerCase()){
            case "client":
                username.sendKeys(ConfigurationReader.getProperty("client"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case"supervisor":
                username.sendKeys(ConfigurationReader.getProperty("supervisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case"employee":
                username.sendKeys(ConfigurationReader.getProperty("employee"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            case"advisor":
                username.sendKeys(ConfigurationReader.getProperty("advisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));
                break;
            default: throw new InputMismatchException("There is not suc a role:"+ role);

        }
loginButton.click();
    }

    /**
     * logOut from application
     * @param drive
     * @autor Ana
     */
 public static void logOut (WebDriver drive){
WebElement userIcon = drive.findElement(By.xpath("//div[@class='v-avatar primary']"));
userIcon.click();
WebElement logOut = drive.findElement(By.xpath("//span[contains(text(),'Log out')]"));
logOut.click();
 }
}
