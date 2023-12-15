package org.ot5usk.steps.assertions;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlertScriptAsserts {

    public static void checkAlertText(String expectedAlertText, String actualAlertText) {
        assertEquals(expectedAlertText, actualAlertText);
    }

    public static void checkAlertExit(WebDriver webDriver) {
        assertThrows(Exception.class, () -> webDriver.switchTo().alert());
    }

    public static void checkTextResult(String expectedTextResult, String actualTextResult) {
        assertEquals(expectedTextResult, actualTextResult);
    }
}
