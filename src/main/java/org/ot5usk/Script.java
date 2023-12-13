package org.ot5usk;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.ot5usk.browser_sessions.BrowserSession;
import org.ot5usk.browser_sessions.ChromeSession;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Script {

    private static ChromeSession chromeSession;


    public static void main(String[] args) throws InterruptedException {
        initBrowserSession();
        openBrowser();
        doTask(chromeSession);
    }

    private static void doTask(BrowserSession browserSession) throws InterruptedException {
        browserSession.goTo("https://www.wildberries.ru");
        browserSession.webDriver.manage().window().setSize(new Dimension(1920,1080));

        WebElement searchBoxById = browserSession.webDriver.findElement(By.id("searchInput"));
        WebElement searchButtonById = browserSession.webDriver.findElement(By.id("applySearchBtn"));

        Thread.sleep(1000);
        searchBoxById.sendKeys("мобильный телефон");
        searchButtonById.click();

        Thread.sleep(1000);
        WebElement firstProductCard = browserSession.webDriver.findElement(By.xpath("//article[@data-nm-id]"));
        firstProductCard.click();

        Thread.sleep(1000);
        WebElement addToBasket = browserSession.webDriver.findElement(By.xpath("//div[@class='product-page__order-buttons']"));
        WebElement expectedItem = browserSession.webDriver.findElement(By.xpath("//h1[@data-link='text{:selectedNomenclature^goodsName}']"));
        String expectedItemName = expectedItem.getText();
        addToBasket.click();

        Thread.sleep(1000);
        WebElement basket = browserSession.webDriver.findElement(By.xpath("//div[@class='navbar-pc__item j-item-basket']"));
        basket.click();

        Thread.sleep(1000);
        WebElement itemFromBasket = browserSession.webDriver.findElement(By.xpath("//div/a/span[@class='good-info__good-name']"));
        String actualItemNameFromBasket = itemFromBasket.getText();
        assertEquals(expectedItemName, actualItemNameFromBasket);
        browserSession.close();
    }

    private static void initBrowserSession() {
        chromeSession = new ChromeSession();
    }

    private static void openBrowser() {
        chromeSession.open();
    }
}