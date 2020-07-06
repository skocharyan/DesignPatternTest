package org.example.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class Items {

    @FindBy(xpath = "//div[@class=inventory_item_name']")
    private By itemName;
    @FindBy(xpath = "//div[@class=inventory_item_price']")
    private By itemPrice;
    private String itemButtonXpath =  "//button[@class='btn_primary btn_inventory']" ;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> item;

    private Items(EventFiringWebDriver webDriver){
        PageFactory.initElements(webDriver , this);
    }

    public static Items start(EventFiringWebDriver eventFiringWebDriver){
        return new Items(eventFiringWebDriver);
    }
    public String getItemName(WebElement element){
        return element.getText();
    }
    public String getItemPrice(WebElement element){
        return element.getText();
    }
    private  String getItemStatus(WebElement element){
        return element.getText();
    }
    public  List<WebElement> getItems(){
        return item;
    }
    public void addItemToCart(WebElement webElement){
        webElement.findElement(By.xpath(itemButtonXpath)).click();
    }
}
