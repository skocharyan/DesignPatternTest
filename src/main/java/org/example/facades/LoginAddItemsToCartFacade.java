package org.example.facades;

import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Properties.MyProperties;
import org.example.exception.PageValidationException;

public class LoginAddItemsToCartFacade {
     private static String browserName = null;
     private static String login = null ;
     private  LoginPage loginPage ;
    private LoginAddItemsToCartFacade(){

    }
    public static LoginAddItemsToCartFacade start(){
        return new LoginAddItemsToCartFacade();
    }
    public static LoginAddItemsToCartFacade start(String browserName){
        LoginAddItemsToCartFacade.browserName = browserName;
        return new LoginAddItemsToCartFacade();
    }
    public LoginAddItemsToCartFacade login(){

      loginPage =  LoginPage.start(browserName).open()
                .fillUserNameField(login)
                .fillPasswordField("secret_sauce")
                .submit();
        return this;
    }
    public  LoginAddItemsToCartFacade setBrowserName(String browserName){
        this.browserName = browserName;
        return this;
    }
    public LoginAddItemsToCartFacade setLogin(String login){
        this.login = login;
        return this;
    }
    public LoginAddItemsToCartFacade  close(){
        loginPage.close();
        return this;
    }
    public LoginAddItemsToCartFacade validate() throws PageValidationException {
        loginPage.validate(MyProperties.start("URL.properties").getProperties("homePageUrl"));
        return this;
    }
    public LoginAddItemsToCartFacade addRandomNumberOfItemTOCart(){
        HomePage.cont().selectMultipleItems();
        return this;
    }
    public LoginAddItemsToCartFacade deleteMultiItems(){
        return this;
    }

}
