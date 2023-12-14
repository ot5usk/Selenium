package org.ot5usk.tasks;

import org.openqa.selenium.WebElement;

public interface FirstTask {

    void execute();

    WebElement enterTextIntoFrame(String frameName);

    void changeTextInFrame(WebElement frame);
}
