package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.CustomFieldDecorator;

public abstract class BasePage {
    protected WebDriver driver;
    protected BrowserService browserService;
    public String baseUrl;
    private final String path;

    public BasePage(BrowserService browserService, String path) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new PropertyReader().getUrl();
        this.path = path;

        PageFactory.initElements(new CustomFieldDecorator(this.driver), this);
    }

    public void open() {
        if (this.path != null) this.driver.get(baseUrl + path);
        waitUntilPageOpened();
    }

    protected abstract By getPageOpenedIndicatorElLocator();

    private void waitUntilPageOpened() {
        var isPageOpened = browserService.getWait()
                .waitForVisibility(getPageOpenedIndicatorElLocator())
                .isDisplayed();

        if (!isPageOpened) {
            throw new AssertionError("Page was not opened");
        }
    }
}
