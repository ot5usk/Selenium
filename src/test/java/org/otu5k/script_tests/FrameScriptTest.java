package org.otu5k.script_tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.ot5usk.steps.scripts.FrameScriptImpl;
import org.ot5usk.steps.scripts.tasks.FrameScript;
import org.otu5k.WebDriverStarter;

public class FrameScriptTest extends WebDriverStarter {

    private static final FrameScript frameScript = new FrameScriptImpl(webDriver);

    @DisplayName("Text editor")
    @Description("Interacting with elements inside a frame")
    @Test
    public void interactWithFrameElements() {
        webDriver.get("https://the-internet.herokuapp.com/frames");
        frameScript.goToFramePage("//a[@href='/iframe']");
        frameScript.switchToFrame("mce_0_ifr");
        WebElement frameBody = frameScript.getFrameBody("//body[@id='tinymce']");
        frameBody = frameScript.enterTextIntoFrameBody(frameBody, "Hello World");
        frameScript.changeTextInFrameBody(frameBody, "//button[@aria-label='Bold']");
    }
}