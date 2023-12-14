package org.ot5usk.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.ot5usk.tasks.SecondTask;
import org.ot5usk.utils.Util;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.ot5usk.scripts.Default.*;

public class SecondScript implements SecondTask {

    private WebDriver webDriver;
    private List<String> handles;

    @Override
    public void execute() {
        webDriver = Util.getBrowserSessionFactory().openBrowserSession();
        implicitExpectations(webDriver);
        setWindowSize(webDriver, 1920, 1080);
        openUrl(webDriver, "https://the-internet.herokuapp.com/windows");
        clickToElement(webDriver, "//a[@href='/windows/new']");
        checkTransition();
        checkText();
        webDriver.close();
        checkReverseTransition();
        webDriver.quit();
    }

    @Override
    public void checkTransition() {
        handles = getHandles(webDriver);
        assertEquals(2, handles.size());
        webDriver.switchTo().window(handles.get(1));
    }

    @Override
    public void checkText() {
        String actualPageText = webDriver.findElement(By.xpath("//div[@class='example']")).getText();
        assertNotEquals("New Page", actualPageText);
    }

    @Override
    public void checkReverseTransition() {
        handles = getHandles(webDriver);
        assertEquals(1, handles.size());
        webDriver.switchTo().window(handles.get(0));
        String actualPageTitle = webDriver.getTitle();
        assertEquals("The Internet", actualPageTitle);
    }
}
