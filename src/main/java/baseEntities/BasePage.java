package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected BrowserService browserService;
    public String baseUrl;

    public BasePage(BrowserService browserService) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new PropertyReader().getUrl();
    }

    public void open() {
        isPageOpened();
    }

    protected abstract By getPageOpenedIndicatorElLocator();

    protected boolean isPageOpened() {
        var isPageOpened = browserService.getWait()
                .waitForVisibility(getPageOpenedIndicatorElLocator())
                .isDisplayed();

        if (!isPageOpened) {
            throw new AssertionError("Page was not opened");
        }
        return true;
    }
}
