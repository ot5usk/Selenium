package org.ot5usk.steps.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WindowScriptAsserts {

    public static void expectedNewHandle(String defaultHandle, String actualHandle) {
        assertNotEquals(defaultHandle, actualHandle);
    }

    public static void expectedDefaultHandle(String defaultHandle, String actualHandle) {
        assertEquals(defaultHandle, actualHandle);
    }

    public static void checkHandlesSize(long expectedHandlesSize, long actualHandleSize) {
        assertEquals(expectedHandlesSize, actualHandleSize);
    }

    public static void checkPageText(String expectedPageText, String actualPageText) {
        assertEquals(expectedPageText, actualPageText);
    }

    public static void checkPageTitle(String expectedPageTitle, String actualPageTitle) {
        assertEquals(expectedPageTitle, actualPageTitle);
    }
}
