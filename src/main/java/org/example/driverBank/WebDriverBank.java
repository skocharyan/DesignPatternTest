package org.example.driverBank;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverBank {
    public  static    EventFiringWebDriver eventFiringWebDriver = null;

    public static EventFiringWebDriver getEventFiringWebDriver() {
        return eventFiringWebDriver;
    }

    public static void setEventFiringWebDriver(EventFiringWebDriver eventFiringWebDriver) {
        WebDriverBank.eventFiringWebDriver = eventFiringWebDriver;
    }
}
