package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @autor Ana
     * note: usually we do not do validation in method, tjis is for practicing purpose
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for(String each: windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
       assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * switches to new window by the exact title
     * returns to original
     * it is reusable method
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }

        driver.switchTo().window(origin);
}

/**
 *
 * @param driver
 * @param expectedTitle
 * returns void, assertion is implemented
 * reusable method
 * @author: Ana
 */
public static void validateTitle(WebDriver driver, String expectedTitle){
    assertTrue(driver.getTitle().contains(expectedTitle));

}
//java DOC
/**
 *Click any link from loop practice
 * @param nameOfthePage
 * @author Ana
 */
public static void loopLinkClick(String nameOfthePage){
    WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//why we need reusable methods: it pelps us to avoiding peretiotion
    //driver utility
    //configuration.property

}

    /**
     * method that will haver over
     * @param element
     * @author Ana
     */
    public static void hoverOverElement(WebElement element){
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(element).perform();
}

//anything related to browser we put here
    /**
     * method which scrolls ti the given element
     * @param  element
     * @author Ana
     */
    public static void scrollToElement (WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

/**
 * method which scroll to element and click ja
 * @param element
 * @author Ana
 */
public static void scrollAndClick(WebElement element){
    ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", element);
}

/**
 * method which will doublle click any giver element
 * @param element
 * @author Ana
 */
    public static void doubleClick(WebElement element){
     new Actions(Driver.getDriver()).doubleClick().perform();
    }

/**
 * method which will wait of provided element to be visible
 * @param element
 * @param timeToWaitSec
 * @return - element
 *  @author Ana
 */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
        }

/**
 * method which will wait of provided element to be invisibility
 * @param element
 * @param timeToWait
 * @author Ana
 */
    public static void waitForInVisibility (WebElement element, int timeToWait){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
        }

/**
 * method which will wait for element to be clickable
 * @param element
 * @param timeOut
 * @returm element
 * @author Ana
 */
    public static WebElement waitForClickable (WebElement element, int timeOut){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
        }

/**
 * method which will performs a pause
 * @param seconds
 * @author Ana
 */
public static void justWait (int seconds) throws InterruptedException {
    try {
        Thread.sleep(seconds * 1000);
    }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
    }
}

/**
 * method wich will
 * @param
 * @authoe Ana
 */

    }
