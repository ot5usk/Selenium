package org.ot5usk.steps.scripts.tasks;

import org.openqa.selenium.WebElement;

public interface FrameScript {

    void goToFramePage(String frameUrl);

    void switchToFrame(String frameName);

    WebElement getFrameBody(String xpathStrategy);

    WebElement enterTextIntoFrameBody(WebElement frame, String text);

    void changeTextInFrameBody(WebElement frame, String buttonXpath);
}
