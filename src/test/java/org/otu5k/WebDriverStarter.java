package org.otu5k;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.ot5usk.utils.BrowserUtil;

import java.time.Duration;

public class WebDriverStarter {

    public static WebDriver webDriver;

    @BeforeAll
    static void on() {
        webDriver = BrowserUtil.getBrowserSessionFactory().openBrowserSession();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterAll
    static void off() {
        webDriver.quit();
    }
}
