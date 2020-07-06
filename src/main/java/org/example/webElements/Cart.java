package org.example.webElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Cart {

    @FindBy(xpath = "//div[@class='shopping_cart_container']") //parent element
    private WebElement cart;

    private Cart(EventFiringWebDriver webDriver){
        PageFactory.initElements(webDriver , this);
    }

    public static Cart start(EventFiringWebDriver eventFiringWebDriver){
        return new Cart(eventFiringWebDriver);
    }
    public WebElement getCart(){
        return cart;
    }

    public int getElementCountInCart(){
        String elements = cart.getText();
        if(elements.equals("")){
            return  0;
        }else{
           return  Integer.parseInt(elements);
        }
    }

}
