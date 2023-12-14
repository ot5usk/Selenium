package org.ot5usk.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.tasks.FirstTask;
import org.ot5usk.utils.Util;

import static org.ot5usk.scripts.Default.*;

public class FirstScript implements FirstTask {

    private WebDriver webDriver;

    @Override
    public void execute() {
        webDriver = Util.getBrowserSessionFactory().openBrowserSession();
        implicitExpectations(webDriver);
        setWindowSize(webDriver, 1920, 1080);
        openUrl(webDriver, "https://the-internet.herokuapp.com/frames");
        clickToElement(webDriver, "//a[@href='/iframe']");
        WebElement frame = enterTextIntoFrame("mce_0_ifr");
        changeTextInFrame(frame);
        webDriver.quit();
    }

    @Override
    public WebElement enterTextIntoFrame(String frameName) {
        webDriver.switchTo().frame( frameName);
        WebElement frame = webDriver.findElement(By.xpath("//body[@id='tinymce']"));
        frame.clear();
        frame.sendKeys("Hello World");
        return frame;
    }

    @Override
    public void changeTextInFrame(WebElement frame) {
        frame.sendKeys(Keys.CONTROL + "a");
        webDriver.switchTo().defaultContent();
        WebElement boldFontBtn = webDriver.findElement(By.xpath("//button[@aria-label='Bold']"));
        boldFontBtn.click();
    }
}
