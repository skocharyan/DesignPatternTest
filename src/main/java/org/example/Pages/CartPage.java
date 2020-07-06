package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Cart;
import org.example.webElements.Items;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class CartPage extends BasePage {

    private static String Url = MyProperties.start("URL.properties").getProperties("cartPageUrl");
    private static EventFiringWebDriver eventFiringWebDriver;

    private List<WebElement> productCollection = Items.start(eventFiringWebDriver).getItems();

    @FindBy(xpath = "//a[@class='btn_secondary']")
    private WebElement continueShopping;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkOut;

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement chart;

    private CartPage(EventFiringWebDriver webDriver) {
        super(webDriver);
    }

    public CartPage open() {
        eventFiringWebDriver.get(Url);
        return this;
    }

    public static CartPage start(String browserName) {
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        return new CartPage(eventFiringWebDriver);
    }

    public CartPage clickContinueShopping() {
        continueShopping.click();
        return this;
    }

    public CartPage clickCheckOut() {
        checkOut.click();
        return this;
    }

    public boolean validate() {
        if (MyProperties.start("URL.properties").getProperties("cartPageUrl").
                equals(eventFiringWebDriver.getCurrentUrl())) {
            return true;
        } else {
            return false;
        }
    }
}
