package SDA.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
/*
    In the POM, instead of extending the TestBase class for Driver,
    it is preferred to create and configure the driver using static methods from the Driver class,
    and closing the driver at the end.
    To prevent the instantiation of Driver class's getDriver() as an object in the POM,
    Singleton pattern usage is adopted.
    Singleton Pattern: Used to prevent the instantiation of a class from different classes.
    To achieve this, the constructor used to create an object is made private.
    When the constructor is private, it is not possible to create an object from outside classes using the 'new' keyword.
 */

public class Driver {
    // Create a private static WebDriver object
    private static WebDriver driver;

    // To make a singleton driver, make the constructor private, so that no objects can be created from outside classes.
    private Driver() { // Constructor Driver
    }

    // Create the getDriver method to create and initiate the driver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            // This ensures that only one driver object is created.
            // If a driver was created before, 'driver' won't be null, and this if block won't execute.
            // It will return the existing (previously created) driver.
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }//getDriver ends here

    // create a closeDriver method to close the driver
    public static void closeDriver() {
        //   quit the driver id it is pointing chromedriver, firefoxdriver....
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}