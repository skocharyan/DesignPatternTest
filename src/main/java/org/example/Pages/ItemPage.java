package org.example.Pages;

import org.example.webElements.Cart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ItemPage  extends  BasePage{
    @FindBy(xpath  = "//button[@class='inventory_details_back_button']")
    private WebElement backButton;
    private static  EventFiringWebDriver eventFiringWebDriver ;
    @FindBy(xpath = "//button[@class='btn_secondary btn_inventory']")
    private WebElement removeButton;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement price;

    private Cart c = Cart.start(eventFiringWebDriver);

    private ItemPage(EventFiringWebDriver webDriver){
        super(webDriver);
    }
    public static ItemPage start(EventFiringWebDriver webDriver){
        return new ItemPage(webDriver);
    }
    public ItemPage open(){
        return this;
    }
    public double getPrice(){
        return Double.parseDouble(price.getText().substring(1));
    }



}
