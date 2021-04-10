package baseEntities;

import core.BrowserService;
import core.PropertyReader;

public abstract class BaseTest {
    protected BrowserService browserService;
    protected PropertyReader propertyReader;

    protected void disposeDriver() {
        this.browserService.getDriver().close();
        this.browserService.getDriver().quit();
        this.browserService = null;
    }
}
