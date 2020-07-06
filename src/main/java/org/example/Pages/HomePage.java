package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.driverBank.WebDriverBank;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Items;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    ///..............
    private int itemsNumber;


    private static String Url = MyProperties.start("URL.properties").getProperties("homePageUrl");

    private static EventFiringWebDriver eventFiringWebDriver;

    private Items items = Items.start(eventFiringWebDriver);

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement chart;

    private HomePage(EventFiringWebDriver webDriver) {
        super(webDriver);
    }

    public HomePage open() {
        eventFiringWebDriver.get(Url);
        return this;
    }

    public static HomePage start(String browserName) {
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        return new HomePage(eventFiringWebDriver);
    }

    public static HomePage cont() {
        eventFiringWebDriver = WebDriverBank.getEventFiringWebDriver();
        return new HomePage(eventFiringWebDriver);
    }

    public HomePage selectMultipleItems() {
        Items items = Items.start(eventFiringWebDriver);
        List<WebElement> itemsList = items.getItems();
        itemsNumber = itemsList.size();
        Random r1 = new Random();
        int r2 = r1.nextInt(itemsNumber);
        Integer[] randomArray = new Integer[r2];

        for (int i = 0; i < r2; i++) {
            Random r = new Random();
            int j = r.nextInt(r2);
            randomArray[i] = j;
        }
        for (int i = 0; i < randomArray.length; i++) {
            WebElement element = itemsList.get(randomArray[i]);
            items.addItemToCart(element);
        }

        return this;
    }

}
