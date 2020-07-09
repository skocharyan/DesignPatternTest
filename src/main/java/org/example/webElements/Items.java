package org.example.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class Items {

//    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private By  itemName = By.xpath(".//div[@class='inventory_item_name']");

    private By itemPrice = By.xpath(".//div[@class='inventory_item_price']");

    private By itemButton = By.xpath(".//button[@class='btn_primary btn_inventory']");

    private By selectedButton = By.xpath(".//button[@class='btn_secondary btn_inventory']");

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> item;

    private Items(EventFiringWebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public static Items start(EventFiringWebDriver eventFiringWebDriver) {
        return new Items(eventFiringWebDriver);
    }

    public String getItemName(WebElement element) {
        return element.findElement(itemName).getText();
    }

    public String getItemPrice(WebElement element) {
        return element.findElement(itemPrice).getText();
    }

    public Boolean getItemStatus(WebElement element) {
        if(element.getText().contains("REMOVE")){
            return true;
        }
        else{
            return false;
        }
    }

    public List<WebElement> getItems() {
        return item;
    }

    public void addItemToCart(WebElement webElement) {
        webElement.findElement(itemButton).click();
    }
    public void deleteItemFromCart(WebElement webElement) {
        webElement.findElement(selectedButton).click();
    }
}
