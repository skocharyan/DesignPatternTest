package org.example.factories;

import org.example.Listeners.WebDriverListeners;
import org.example.Properties.MyProperties;
import org.example.options.CustomChromeOptions;
import org.example.options.CustomFirefoxOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverFactory {

    private EventFiringWebDriver eventFiringWebDriver;
    private String browserName;

    private WebDriverFactory(String browserName) {
        this.browserName = browserName;
    }

    public static WebDriverFactory start(String browserName) {
        return new WebDriverFactory(browserName);
    }

    public WebDriverFactory generateWebDriver() {
        setSystemProperties();
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver(new CustomChromeOptions().getOptions());
                break;
            case "firefox":
                driver = new FirefoxDriver(new CustomFirefoxOptions().getOptions());
                break;
            default:
                System.out.println("such a  browser do not exist");
        }
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebDriverListeners webDriverListeners = new WebDriverListeners();
        this.eventFiringWebDriver = eventFiringWebDriver.register(webDriverListeners);
        return this;

    }

    private static void setSystemProperties() {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            String path = MyProperties.start().getProperties("chromeDriver");
            System.setProperty("webdriver.chrome.driver", path);
        }
    }

    public EventFiringWebDriver getDriver() {
        return eventFiringWebDriver;
    }
}
