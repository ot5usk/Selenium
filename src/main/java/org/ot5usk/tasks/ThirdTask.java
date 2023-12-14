package org.ot5usk.tasks;

import org.openqa.selenium.Alert;

public interface ThirdTask {

    void execute();

    void jsAlert();

    void jsConfirm();

    void jsPrompt();

    void checkAlertText(Alert alert);

    void checkAlertExit();

    void checkTextResult();
}
