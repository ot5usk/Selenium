package org.ot5usk.steps.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.steps.scripts.tasks.FrameScript;


public class FrameScriptImpl implements FrameScript {

    private final WebDriver webDriver;

    public FrameScriptImpl(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void goToFramePage(String frameXpath) {
        WebElement frameHref = webDriver.findElement(By.xpath(frameXpath));
        frameHref.click();
    }

    @Override
    public void switchToFrame(String frameName) {
        webDriver.switchTo().frame(frameName);
    }

    @Override
    public WebElement getFrameBody(String bodyXpath) {
        return webDriver.findElement(By.xpath(bodyXpath));
    }

    @Override
    public WebElement enterTextIntoFrameBody(WebElement frame, String text) {
        frame.clear();
        frame.sendKeys(text);
        return frame;
    }

    @Override
    public void changeTextInFrameBody(WebElement frame, String buttonXpath) {
        frame.sendKeys(Keys.CONTROL + "a");
        webDriver.switchTo().defaultContent();
        WebElement boldFontBtn = webDriver.findElement(By.xpath(buttonXpath));
        boldFontBtn.click();
    }
}
