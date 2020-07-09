package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.driverBank.WebDriverBank;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Cart;
import org.example.webElements.Items;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    ///..............
    private int itemsNumber;
    private static String Url = MyProperties.start("URL.properties").getProperties("homePageUrl");
    private static EventFiringWebDriver eventFiringWebDriver;
    private Items items = Items.start(eventFiringWebDriver);
    private Cart cart = Cart.start(eventFiringWebDriver);

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement chart;
    private List<WebElement> itemsList;
    private int selectedItemNumber;
    private List<Integer> randomList;

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
        itemsList = items.getItems();
        itemsNumber = itemsList.size();
        Random r = new Random();
        int elNumber = r.nextInt(itemsNumber); // determine number of element for selection;
        List<Integer> randomNumberList = new ArrayList<>(); // crating array of structured number
        for (int i = 0; i < itemsNumber; i++) {
            randomNumberList.add(i);
        }
        Collections.shuffle(randomNumberList); // mixing elements // making theme random
        randomList = randomNumberList.subList(0, elNumber);
        selectedItemNumber = randomList.size();

        for (int i = 0; i < randomList.size(); i++) {
            WebElement element = itemsList.get(randomList.get(i));
            items.addItemToCart(element);
        }
        logger.debug("adding " + randomList.size() + " item to cart");
        return this;
    }

    public HomePage validateNumberOfItemInCart() {
        Cart c = Cart.start(eventFiringWebDriver);
        if (selectedItemNumber == c.getElementCountInCart()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
        return this;
    }

    public HomePage deleteRandomSelectedItems() {
        for (int i = 0; i < randomList.size(); i++) {
            WebElement element = itemsList.get(randomList.get(i));
            if (items.getItemStatus(element)) {
                items.deleteItemFromCart(element); //removing items
            }
        }
        logger.debug("deleting " + randomList.size() + " item from cart");
        return this;
    }
}
