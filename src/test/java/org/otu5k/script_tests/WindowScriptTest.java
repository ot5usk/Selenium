package org.otu5k.script_tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ot5usk.steps.scripts.WindowScriptImpl;
import org.ot5usk.steps.scripts.tasks.WindowScript;
import org.otu5k.WebDriverStarter;

import java.util.List;

import static org.ot5usk.steps.assertions.WindowScriptAsserts.*;

public class WindowScriptTest extends WebDriverStarter {

    private static final WindowScript windowScript = new WindowScriptImpl(webDriver);
    private final String defaultHandle = webDriver.getWindowHandle();
    private List<String> actualHandles = windowScript.getHandles();

    public void goToNewPage() {
        windowScript.openNewWindow("//a[@href='/windows/new']");
        actualHandles = windowScript.getHandles();
        checkHandlesSize(2, actualHandles.size());
        windowScript.switchToNewWindow(defaultHandle, actualHandles);
        expectedNewHandle(defaultHandle, webDriver.getWindowHandle());
    }

    public void goBack() {
        windowScript.closeCurrentWindow();
        actualHandles = windowScript.getHandles();
        checkHandlesSize(1, actualHandles.size());
        webDriver.switchTo().window(defaultHandle);
        expectedDefaultHandle(defaultHandle, webDriver.getWindowHandle());
    }

    @DisplayName("Switching browser tabs/windows")
    @Description("To a new one and back")
    @Test
    void testWindowSwitching() {
        webDriver.get("https://the-internet.herokuapp.com/windows");
        goToNewPage();
        String actualNewPageText = windowScript.getPageText("//div[@class='example']");
        checkPageText("New Page", actualNewPageText);
        goBack();
        checkPageTitle("The Internet", webDriver.getTitle());
    }
}
