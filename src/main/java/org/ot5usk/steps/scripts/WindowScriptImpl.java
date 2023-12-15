package org.ot5usk.steps.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.steps.scripts.tasks.WindowScript;

import java.util.List;

public class WindowScriptImpl implements WindowScript {

    private final WebDriver webDriver;

    public WindowScriptImpl(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void openNewWindow(String windowHrefXpath) {
        WebElement windowHref = webDriver.findElement(By.xpath(windowHrefXpath));
        windowHref.click();
    }

    @Override
    public void switchToNewWindow(String defaultHandle, List<String> actualHandles) {
        for (String handle : actualHandles) {
            if (!handle.equals(defaultHandle)) {
                webDriver.switchTo().window(handle);
            }
        }
    }

    @Override
    public List<String> getHandles() {
        return webDriver.getWindowHandles().stream().toList();
    }

    @Override
    public String getPageText(String elementWithTextXpath) {
        return webDriver.findElement(By.xpath(elementWithTextXpath)).getText();
    }

    @Override
    public void closeCurrentWindow() {
        webDriver.close();
    }
}
