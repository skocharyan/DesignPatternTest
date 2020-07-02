package org.example.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class Items {

    @FindBy(xpath = "//div[@class='inventory_item']//div[@class=inventory_item_name']")
    private WebElement itemName;

    @FindBy(xpath = "//div[@class='inventory_item']//div[@class=inventory_item_price']")
    private WebElement itemPrice;
    @FindBy(xpath = "//div[@class='inventory_item']//button[@class='btn_primary btn_inventory']")
    private WebElement  itemButton;
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> item;

    private Items(EventFiringWebDriver webDriver){
        PageFactory.initElements(webDriver , this);
    }

    public static Items getItems(EventFiringWebDriver eventFiringWebDriver){
        return new Items(eventFiringWebDriver);
    }
    public String getItemName(){
        return itemName.getText();
    }
    public String getItemPrice(){
        return itemPrice.getText();
    }
    private  String getItemStatus(){
        return itemButton.getText();
    }
    public  List<WebElement> getItem(){
        return item;
    }
}
