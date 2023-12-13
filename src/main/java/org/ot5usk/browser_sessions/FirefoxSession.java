package org.ot5usk.browser_sessions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class FirefoxSession extends BrowserSession {

    @Override
    public void open() {
        super.webDriver = new FirefoxDriver(new GeckoDriverService.Builder().build());
    }
}
