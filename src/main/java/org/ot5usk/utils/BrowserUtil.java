package org.ot5usk.utils;

import org.ot5usk.utils.browser_sessions_factory.BrowserSessionFactory;
import org.ot5usk.utils.browser_sessions_factory.ChromeSessionFactory;

public class BrowserUtil {

    private static BrowserSessionFactory browserSessionFactory;

    static {
        initBrowserSessionFactory();
    }

    private static void initBrowserSessionFactory() {
        browserSessionFactory = new ChromeSessionFactory();
    }

    public static BrowserSessionFactory getBrowserSessionFactory() {
        return browserSessionFactory;
    }
}
