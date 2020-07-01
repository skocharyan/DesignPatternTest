package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class PaymentConfirmation extends  BasePage {
    private static String Url = MyProperties.start("URL.properties").getProperties("checkOutUrl");
    private static EventFiringWebDriver eventFiringWebDriver;
    @FindBy(xpath = "//div[@class='cart_item']")
    private List<WebElement> productCollection;

    @FindBy(xpath = "//a[@class='cart_cancel_link btn_secondary']")
    private WebElement cancel;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement finish;

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement chart;

    private PaymentConfirmation(EventFiringWebDriver webDriver) {
        super(webDriver);
    }

    public PaymentConfirmation open() {
        eventFiringWebDriver.get(Url);
        return this;
    }

    public static PaymentConfirmation start(String browserName) {
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        return new PaymentConfirmation(eventFiringWebDriver);
    }

    public PaymentConfirmation clickContinueShopping(){
        cancel.click();
        return this;
    }
    public PaymentConfirmation clickCheckOut(){
        finish.click();
        return this;
    }

}
