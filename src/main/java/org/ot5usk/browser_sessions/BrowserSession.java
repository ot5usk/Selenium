package org.ot5usk.browser_sessions;

import org.openqa.selenium.WebDriver;

public abstract class BrowserSession {

    public WebDriver webDriver;

    public abstract void open();

    public void goTo(String url) {
        webDriver.get(url);
    }

    public void close() {
        webDriver.quit();
    }
}
