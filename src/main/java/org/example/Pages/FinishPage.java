package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.factories.WebDriverFactory;
import org.example.webElements.Cart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FinishPage extends BasePage {
    private static  EventFiringWebDriver eventFiringWebDriver ;
    private  String headerName ="THANK YOU FOR YOUR ORDER" ;
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement header;
    //-------------------------------------
    private Cart cart = Cart.start(eventFiringWebDriver);

    private static String Url = MyProperties.start("URL.properties").getProperties("finishUrl");
    private FinishPage(EventFiringWebDriver webDriver){
        super(webDriver);
    }
    public static FinishPage start(String browserName ){
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        return new FinishPage(eventFiringWebDriver);
    }
    public FinishPage open(){
        eventFiringWebDriver.get(Url);
        return this;
    }
    public String getTitle(){
        return header.getText();
    }

}
