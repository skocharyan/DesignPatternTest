package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.driverBank.WebDriverBank;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Cart;
import org.example.webElements.Items;
import org.openqa.selenium.By;
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
    private Integer[] randomArray;


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

    public HomePage
    selectMultipleItems() {
        itemsList = items.getItems();
        itemsNumber = itemsList.size();
        System.out.println(itemsNumber);

        Random r = new Random();
        int elNumber = r.nextInt(itemsNumber); // determine number of element for selection;
        List<Integer> randomNumberList = new ArrayList<>(); // crating array of structured number
        for (int i = 0; i < itemsNumber; i++) {
            randomNumberList.add(i);
        }
        Collections.shuffle(randomNumberList); // mixing elements // making theme random
        List<Integer> randomList = randomNumberList.subList(0, elNumber);
        System.out.println(randomList);

        for (int i = 0; i < randomList.size(); i++) {
            WebElement element = itemsList.get(randomList.get(i));
            items.addItemToCart(element);
            System.out.println(i + "    " + randomList.get(i) + " " +  items.getItemName(element));
        }
        return this;
    }

//    public HomePage deleteMultipleItemsFromCart() {
//        logger.info("deleting multiple items ");
//        System.out.println(randomArray);
//        for (int i = 0; i < randomArray.length; i++) {
//            WebElement element = itemsList.get(randomArray[i]);
//            System.out.println(randomArray);
//            items.addItemToCart(element);
//        }
//        if (cart.getElementCountInCart() == 0) {
//            Assert.assertTrue(true);
//        } else {
//            Assert.assertTrue(false);
//        }
//        return this;
//    }


}
