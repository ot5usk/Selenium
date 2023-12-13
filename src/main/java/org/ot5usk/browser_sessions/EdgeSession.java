package org.ot5usk.browser_sessions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

public class EdgeSession extends BrowserSession {

    @Override
    public void open() {
        super.webDriver = new EdgeDriver(new EdgeDriverService.Builder().build());
    }
}
