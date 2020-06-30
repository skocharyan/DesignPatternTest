package org.example;

import org.example.Pages.HomePage;
import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class app {
    public static void main(String[] args) {
//        String path = MyProperties.start().getProperties("chromeDriver");
//        System.setProperty("webdriver.chrome.driver", path);
//        MutableCapabilities options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--disable-blink-features");
//        ((ChromeOptions) options).addArguments("--disable-blink-features=AutomationControlled");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--profile-directory=Default");
//        options.addArguments("--disable-plugins-discovery");
//        WebDriver driver =  new ChromeDriver(options);
//        driver.get("https://ebanking.conversebank.am/InternetBank/MainForm.wgx");
////
//        driver.findElement(By.xpath("//input[@class='cba3 cba4 cba2']")).sendKeys("SKA30585850");
//        driver.findElement(By.xpath("//input[@class='cba3 cba4 cba2'][1]")).sendKeys("SKA30585850");
          HomePage.start("chrome");
    }
}
