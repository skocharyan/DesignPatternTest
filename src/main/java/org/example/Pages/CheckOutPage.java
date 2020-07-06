package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Cart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class CheckOutPage extends BasePage {

    private static String Url = MyProperties.start("URL.properties").getProperties("checkOutUrl");
    private static EventFiringWebDriver eventFiringWebDriver;
    @FindBy(xpath = "//div[@class='https://www.saucedemo.com/cart.html']")
    private List<WebElement> productCollection;

    @FindBy(xpath = "//a[@class='btn_secondary']")
    private WebElement continueShopping;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkOut;

    private Cart chart = Cart.start(eventFiringWebDriver);
    /*  importing cart class as element */

    private CheckOutPage(EventFiringWebDriver webDriver) {
        super(webDriver);
    }

    public CheckOutPage open() {
        eventFiringWebDriver.get(Url);
        return this;
    }

    public static CheckOutPage start(String browserName) {
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        return new CheckOutPage(eventFiringWebDriver);
    }

    public CheckOutPage clickContinueShopping(){
        continueShopping.click();
        return this;
    }
    public CheckOutPage clickCheckOut(){
        checkOut.click();
        return this;
    }
}
