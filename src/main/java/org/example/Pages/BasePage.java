package org.example.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exception.PageValidationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    protected EventFiringWebDriver driver;
    private WebDriverWait wait;
    protected  Logger logger = LogManager.getLogger(BasePage.class);
    public BasePage(EventFiringWebDriver driver ) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }
    protected void setWindowSize( ){
        driver.manage().window().maximize();
    }

    protected void waitForElementToAppear(WebElement element ) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForTextToDisappear(WebElement element , String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe((By) element , text)));
    }
}