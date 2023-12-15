package org.ot5usk.steps.scripts.tasks;

import java.util.List;

public interface WindowScript {

    void openNewWindow(String windowHrefXpath);

    void switchToNewWindow(String defaultHandle, List<String> actualHandles);

    List<String> getHandles();

    String getPageText(String elementWithTextXpath);

    void closeCurrentWindow();
}