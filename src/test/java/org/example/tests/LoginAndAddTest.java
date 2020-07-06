package org.example.tests;

import org.example.exception.PageValidationException;
import org.example.facades.LoginAddItemsToCartFacade;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class LoginAndAddTest {

    private String browserName;
    private LoginAddItemsToCartFacade loginAddItemsToCartFacade;

    @Parameters({"login", "browserName"})
    @Test
    public void loginAndChoseItems(String login, String browserName) throws PageValidationException {
        this.browserName = browserName;
        loginAddItemsToCartFacade = LoginAddItemsToCartFacade.start().setBrowserName(browserName).setLogin(login)
                .login()
                .validate();
    }
    @Test(dependsOnMethods = "loginAndChoseItems" )
    public void addRandomMultiItems(){
        loginAddItemsToCartFacade.addRandomNumberOfItemTOCart();
    }

    @AfterTest
    public void afterTest() {
    }
}
