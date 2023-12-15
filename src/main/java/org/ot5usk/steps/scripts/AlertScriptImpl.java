package org.ot5usk.steps.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ot5usk.steps.scripts.tasks.AlertScript;

public class AlertScriptImpl implements AlertScript {

    private final WebDriver webDriver;

    public AlertScriptImpl(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void clickJsAlert(String jsAlertBtnXpath) {
        WebElement jsAlertBtn = webDriver.findElement(By.xpath(jsAlertBtnXpath));
        jsAlertBtn.click();
    }

    @Override
    public void clickJsConfirm(String jsConfirmBtnXpath) {
        WebElement jsConfirmBtn = webDriver.findElement(By.xpath(jsConfirmBtnXpath));
        jsConfirmBtn.click();
    }

    @Override
    public void clickJsPrompt(String jsPromptBtnXpath) {
        WebElement jsPromptBtn = webDriver.findElement(By.xpath(jsPromptBtnXpath));
        jsPromptBtn.click();
    }


    @Override
    public String getTextResult(String resultXpath) {
        return webDriver.findElement(By.xpath(resultXpath)).getText();
    }
}
