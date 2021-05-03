package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.JsExecutorClient;
import utils.Waiter;

public class ElementWrapper {
    protected final BrowserService browserService;
    protected final Element element;
    protected final Actions actions;
    protected final JsExecutorClient jsExecutorClient;
    protected final Waiter waiter;

    public ElementWrapper(BrowserService browserService, By by) {
        this(browserService, browserService.getDriver().findElement(by));
    }

    public ElementWrapper(BrowserService browserService, WebElement element) {
        this.browserService = browserService;
        this.element = new Element(this.browserService, element);
        this.actions = new Actions(this.browserService.getDriver());
        this.jsExecutorClient = JsExecutorClient.get(this.browserService);
        this.waiter = this.browserService.getWait();
    }
}
