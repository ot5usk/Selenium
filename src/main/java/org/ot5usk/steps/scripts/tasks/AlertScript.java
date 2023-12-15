package org.ot5usk.steps.scripts.tasks;

public interface AlertScript {

    void clickJsAlert(String buttonXpath);

    void clickJsConfirm(String buttonXpath);

    void clickJsPrompt(String buttonXpath);

    String getTextResult(String resultXpath);
}
