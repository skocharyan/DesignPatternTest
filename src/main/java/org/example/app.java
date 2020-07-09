package org.example;

import org.example.Properties.MyProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class app {
    public static void main(String[] args) throws IOException {
        String path = MyProperties.start().getProperties("chromeDriver");
        System.setProperty("webdriver.chrome.driver", path);
//        MutableCapabilities options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--disable-blink-features");
//        ((ChromeOptions) options).addArguments("--disable-blink-features=AutomationControlled");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--profile-directory=Default");
//        options.addArguments("--disable-plugins-discovery");
//        WebDriver driver =  new ChromeDriver();
//        driver.get("https://ebanking.conversebank.am/InternetBank/MainForm.wgx");
////
//        WebElement element = driver.findElement(By.xpath("//input[@class='cba3 cba4 cba2']"));
//        element.findElement()
//        driver.findElement(By.xpath("//input[@class='cba3 cba4 cba2'][1]")).sendKeys("SKA30585850")
//        Assert.assertTrue(false);
//
//        int randomNumber = 4 ;
//        ChromeOptions options  = new ChromeOptions();
//        options.addArguments("ignore-certificate-errors");
//        WebDriver  driver = new ChromeDriver(options);
//        driver.get("https://www.saucedemo.com/inventory.html");
//
//        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//        System.out.println(elementList.size());
//        By x = By.xpath(".//div[@class='inventory_item_price']");
//        WebElement element = elementList.get(randomNumber).findElement(x);
//        System.out.println(element.getText());
//
//        System.out.println(elementList.get(randomNumber).getText());
    }
}
