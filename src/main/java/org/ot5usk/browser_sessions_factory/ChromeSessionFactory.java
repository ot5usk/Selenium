package org.ot5usk.browser_sessions_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeSessionFactory implements BrowserSessionFactory {

    @Override
    public WebDriver openBrowserSession() {
        return new ChromeDriver(new ChromeDriverService.Builder().build());
    }
}
