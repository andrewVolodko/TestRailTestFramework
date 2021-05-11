package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected BrowserService browserService;
    public final String baseUrl;
    private final String path;

    public BasePage(BrowserService browserService, String path) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new PropertyReader().getBaseUrl();
        this.path = path;
    }

    public void open() {
        if (this.path != null) this.driver.get(baseUrl + path);
        try {
            this.browserService.getWait().waitForVisibility(getPageOpenedIndicatorElLocator());
        } catch (TimeoutException ex){
            throw new AssertionError("Page was not opened");
        }
    }

    protected abstract By getPageOpenedIndicatorElLocator();
}
