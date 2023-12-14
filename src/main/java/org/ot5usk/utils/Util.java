package org.ot5usk.utils;

import org.ot5usk.browser_sessions_factory.BrowserSessionFactory;
import org.ot5usk.browser_sessions_factory.ChromeSessionFactory;

public class Util {

    private static BrowserSessionFactory browserSessionFactory;

    static {
        initBrowserSessionFactory();
    }

    public static BrowserSessionFactory getBrowserSessionFactory() {
        return browserSessionFactory;
    }

    private static void initBrowserSessionFactory() {
        browserSessionFactory = new ChromeSessionFactory();
    }
}
