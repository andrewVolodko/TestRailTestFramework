package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.customFieldDecorator.CustomFieldDecorator;

public abstract class BasePage {
    protected WebDriver driver;
    protected BrowserService browserService;
    public final String baseUrl;
    private final String path;

    public BasePage(BrowserService browserService, String path) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new PropertyReader().getUrl();
        this.path = path;

        PageFactory.initElements(new CustomFieldDecorator(this.browserService), this);
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
