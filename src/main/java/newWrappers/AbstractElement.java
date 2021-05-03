package newWrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.JsExecutorClient;
import utils.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractElement {
    protected final BrowserService browserService;
    protected final WebElement element;
    protected final Actions actions;
    protected final JsExecutorClient jsExecutorClient;
    protected final Waiter waiter;

    public AbstractElement(BrowserService browserService, WebElement element) {
        this.browserService = browserService;
        this.element = element;
        this.actions = new Actions(browserService.getDriver());
        this.jsExecutorClient = JsExecutorClient.get(browserService);
        this.waiter = browserService.getWait();
    }

    public AbstractElement(BrowserService browserService, By by){
        this(browserService, browserService.getDriver().findElement(by));
    }

    public void click() {
        try {
            this.element.click();
        } catch (Exception ex) {
            try {
                actions.moveToElement(this.element)
                        .click()
                        .build()
                        .perform();
            } catch (Exception ex1) {
                jsExecutorClient.clickOnElement(this.element);
            }
        }
    }

    public void clear() {
        this.element.clear();
    }

    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    public List<Element> findElements(By by) {
        return this.element.findElements(by)
                .stream()
                .map(el -> new Element(this.browserService, el))
                .collect(Collectors.toList());
    }

    public Element findElement(By by) {
        return new Element(this.browserService, this.element.findElement(by));
    }

    public Element getParent() {
        return this.findElement(By.xpath("./.."));
    }
}
