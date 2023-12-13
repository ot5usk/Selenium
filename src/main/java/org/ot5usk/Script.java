package org.ot5usk;

import org.ot5usk.browser_sessions.BrowserSession;
import org.ot5usk.browser_sessions.ChromeSession;
import org.ot5usk.browser_sessions.EdgeSession;
import org.ot5usk.browser_sessions.FirefoxSession;

public class Script {

    private static ChromeSession chromeSession;
    private static FirefoxSession firefoxSession;
    private static EdgeSession edgeSession;

    public static void main(String[] args) throws InterruptedException {
        initAllBrowserSessions();
        openAllBrowsers();
        doTask(chromeSession);
        doTask(firefoxSession);
        doTask(edgeSession);
    }

    private static void doTask(BrowserSession browserSession) throws InterruptedException {
        browserSession.goTo("https://www.ya.ru");
        Thread.sleep(1000);
        browserSession.close();
    }

    private static void initAllBrowserSessions() {
        chromeSession = new ChromeSession();
        firefoxSession = new FirefoxSession();
        edgeSession = new EdgeSession();
    }

    private static void openAllBrowsers() {
        chromeSession.open();
        firefoxSession.open();
        edgeSession.open();
    }
}
