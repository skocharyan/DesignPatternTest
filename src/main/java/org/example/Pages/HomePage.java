package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Items;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class HomePage extends BasePage {
    private static String Url = MyProperties.start("URL.properties").getProperties("homePageUrl");
    private static EventFiringWebDriver eventFiringWebDriver;

    private Items itemsList = Items.getItems(eventFiringWebDriver);

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

}
