package org.example.options;

import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeOptions {

    public ChromeOptions getOptions(){
        ChromeOptions chromeOptions  = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");
        return chromeOptions;
    }
}
