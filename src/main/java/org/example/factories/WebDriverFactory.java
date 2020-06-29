package org.example.factories;

import org.example.Properties.MyProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    WebDriverFactory() {
    }

    public static WebDriver generateWebDriver(String name) {
        setSystemProperties();
        WebDriver driver = null;
        switch (name) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("such a  browser do not exist");
        }

        return driver;

    }

    private static void setSystemProperties() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            String path = MyProperties.start().getProperties("chromeDriver");
            System.setProperty("webdriver.chrome.driver", path);
        }
    }
}
