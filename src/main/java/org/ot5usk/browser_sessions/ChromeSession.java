package org.ot5usk.browser_sessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeSession extends BrowserSession {

    @Override
    public void open() {
        super.webDriver = new ChromeDriver(new ChromeDriverService.Builder().build());
    }
}
