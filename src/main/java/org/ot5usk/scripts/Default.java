package org.ot5usk.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class Default {

    public static void implicitExpectations(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void setWindowSize(WebDriver webDriver, int width, int height) {
        webDriver.manage().window().setSize(new Dimension(width, height));
    }

    public static void openUrl(WebDriver webDriver, String url) {
        webDriver.get(url);
    }

    public static void clickToElement(WebDriver webDriver, String xpathStrategy) {
        WebElement element = webDriver.findElement(By.xpath(xpathStrategy));
        element.click();
    }

    public static List<String> getHandles(WebDriver webDriver) {
        return webDriver.getWindowHandles().stream().toList();
    }
}