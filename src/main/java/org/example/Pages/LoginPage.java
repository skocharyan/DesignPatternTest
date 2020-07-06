package org.example.Pages;

import org.example.Properties.MyProperties;
import org.example.driverBank.WebDriverBank;
import org.example.exception.PageValidationException;
import org.example.factories.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginPage extends  BasePage{
    //variables

    private static  EventFiringWebDriver eventFiringWebDriver;

    @FindBy(id = "user-name")
    private WebElement userNameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type = 'submit']")
    private WebElement submit;
    private static   String Url = MyProperties.start("URL.properties").getProperties("loginPageUrl");
    private LoginPage(EventFiringWebDriver webDriver){
        super(webDriver);
    }

    public static LoginPage start(String browserName) {
        eventFiringWebDriver = WebDriverFactory.start(browserName).generateWebDriver().getDriver();
        WebDriverBank.setEventFiringWebDriver(eventFiringWebDriver);
        return new LoginPage(eventFiringWebDriver);
    }

    public LoginPage open(){
        eventFiringWebDriver.get(Url);
        setWindowSize();
        return this;
    }
    public LoginPage setUp(){

        return this;
    }

    //
    public LoginPage fillUserNameField(String userName){
        userNameField.sendKeys(userName);
        return this;
    }
    public LoginPage fillPasswordField(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage  submit(){
        submit.click();
        return this;
    }
    public LoginPage close(){
        driver.quit();
        return this;
    }

    public LoginPage execute(String userName , String password ){
        fillUserNameField(userName);
        fillPasswordField(password);
        submit();
        return this;
    }
    public LoginPage validate(String url) throws PageValidationException {
        if(!driver.getCurrentUrl().equals(url)){
            throw  new PageValidationException(eventFiringWebDriver.getCurrentUrl() + " validation exception") ;
        }
        return this;
    }
}
