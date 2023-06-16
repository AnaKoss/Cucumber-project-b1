package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
    creating the private constructor so this class's object is not reachable from outside
     */

    private Driver(){
    }

    /*
    making driver instance private
    static - run before everything else and also use in static method
     */
    private static WebDriver driver;

    /*
    we need reusable method that will return the same driver instance every time when called
     */

    /**
     * singleton pattern
     * @return driver
     * @autor Ana
     */

    public static WebDriver getDriver(){

        if(driver==null){
            String browserType=ConfigurationReader.getProperty("browser");
            switch(browserType.toLowerCase()){
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver =new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * closing driver
     * @autor nsh
     */

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
