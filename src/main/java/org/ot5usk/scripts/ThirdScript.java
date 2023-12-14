package org.ot5usk.scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ot5usk.tasks.ThirdTask;
import org.ot5usk.utils.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.ot5usk.scripts.Default.*;

public class ThirdScript implements ThirdTask {

    private WebDriver webDriver;

    @Override
    public void execute() {
        webDriver = Util.getBrowserSessionFactory().openBrowserSession();
        implicitExpectations(webDriver);
        setWindowSize(webDriver, 1920, 1080);
        openUrl(webDriver, "https://the-internet.herokuapp.com/javascript_alerts");
        jsAlert();
        jsConfirm();
        jsPrompt();
        webDriver.quit();
    }

    @Override
    public void jsAlert() {
        clickToElement(webDriver, "//button[@onclick='jsAlert()']");
        Alert alert = webDriver.switchTo().alert();
        checkAlertText(alert);
        alert.accept();
        checkAlertExit();
    }

    @Override
    public void jsConfirm() {
        clickToElement(webDriver, "//button[@onclick='jsConfirm()']");
        Alert alert = webDriver.switchTo().alert();
        alert.dismiss();
        checkAlertExit();
    }

    @Override
    public void jsPrompt() {
        clickToElement(webDriver, "//button[@onclick='jsPrompt()']");
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Hello World");
        alert.accept();
        checkTextResult();
    }

    @Override
    public void checkAlertText(Alert alert) {
        assertEquals("I am a JS Alert", alert.getText());
    }

    @Override
    public void checkAlertExit() {
        assertThrows(Exception.class, () -> webDriver.switchTo().alert());
    }

    @Override
    public void checkTextResult() {
        String actualTextResult = webDriver.findElement(By.xpath("//p[@id='result']")).getText();
        assertEquals("You entered: Hello World", actualTextResult);
    }
}
