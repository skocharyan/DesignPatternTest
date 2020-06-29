package org.example.Pages;

import lombok.Singular;
import org.example.factories.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class HomePage  extends  BasePage{

    @FindBy(xpath = "")
    private WebElement SignInButton;

    public HomePage(WebDriver webDriver){
        super(webDriver);

    }
    public static HomePage start(String browserName){
        WebDriver webDriver  = WebDriverFactory.generateWebDriver(browserName);
        webDriver.get("https://www.youtube.com/watch?v=qFdP0XlAVaE&list=RDvOzxxyL9C2M&index=15");
        return new HomePage(webDriver);
    }

}
