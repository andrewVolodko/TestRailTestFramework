package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public abstract class BasePage {
    protected BrowserService browserService;
    public final String baseUrl;
    private final String path;

    public BasePage(BrowserService browserService, String path) {
        this.browserService = browserService;
        this.baseUrl = PropertyReader.getBaseUrl();
        this.path = path;
    }

    public void open() {
        if (this.path != null) this.browserService.getDriver().get(baseUrl + path);
        this.verifyPageOpened();
    }

    public void verifyPageOpened() {
        try {
            this.browserService.getWait().waitForVisibility(getPageOpenedIndicatorElLocator());
        } catch (TimeoutException ex) {
            throw new AssertionError("Page was not opened");
        }
    }
    public void openAndVerifyThatOpened(){
        this.open();
        this.verifyPageOpened();
    }

    protected abstract By getPageOpenedIndicatorElLocator();
}
