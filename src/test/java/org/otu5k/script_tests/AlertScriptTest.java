package org.otu5k.script_tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.ot5usk.steps.scripts.AlertScriptImpl;
import org.ot5usk.steps.scripts.tasks.AlertScript;
import org.otu5k.WebDriverStarter;

import static org.ot5usk.steps.assertions.AlertScriptAsserts.*;

public class AlertScriptTest extends WebDriverStarter {

    private static final AlertScript alertScript = new AlertScriptImpl(webDriver);
    private Alert alert;

    @BeforeEach
    void openUrl() {
        webDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @DisplayName("Click for JS Alert")
    @Description("Check alert: text, exit")
    @Test
    void testJsAlert() {
        alertScript.clickJsAlert("//button[@onclick='jsAlert()']");
        alert = webDriver.switchTo().alert();
        String actualAlertText = alert.getText();
        checkAlertText("I am a JS Alert", actualAlertText);
        alert.accept();
        checkAlertExit(webDriver);
    }

    @DisplayName("Click for JS Confirm")
    @Description("Check alert: exit")
    @Test
    void testJsConfirm() {
        alertScript.clickJsConfirm("//button[@onclick='jsConfirm()']");
        alert = webDriver.switchTo().alert();
        alert.dismiss();
        checkAlertExit(webDriver);
    }

    @DisplayName("Click for JS Prompt")
    @Description("Check result text after click")
    @Test
    void testJsPrompt() {
        alertScript.clickJsPrompt("//button[@onclick='jsPrompt()']");
        alert = webDriver.switchTo().alert();
        alert.sendKeys("Hello World");
        alert.accept();
        String actualTextResult = alertScript.getTextResult("//p[@id='result']");
        checkTextResult("You entered: Hello World", actualTextResult);
    }
}
