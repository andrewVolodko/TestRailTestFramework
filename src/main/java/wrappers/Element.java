package wrappers;

import core.BrowserService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.JsExecutorClient;
import utils.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class Element implements WebElement, IElement {

    private final BrowserService browserService;
    private final WebElement element;
    private final Actions actions;
    private final JsExecutorClient jsExecutorClient;
    private final Waiter waiter;

    public Element(BrowserService browserService, By by) {
        this(browserService, browserService.getDriver().findElement(by));
    }

    public Element(BrowserService browserService, WebElement element) {
        this.browserService = browserService;
        this.element = element;
        this.actions = new Actions(browserService.getDriver());
        this.jsExecutorClient = JsExecutorClient.get(browserService);
        this.waiter = browserService.getWait();
    }

    private Element(BrowserService browserService){
        this(browserService, browserService.getDriver().findElement(By.xpath("//*")));
    }

    public WebElement getWebElement() {
        return this.element;
    }

    @Override
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

    @Override
    public void submit() {
        this.element.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        this.element.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.element.clear();
    }

    @Override
    public String getTagName() {
        return this.element.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return this.element.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return this.element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    @Override
    public String getText() {
        return this.element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.element.findElements(by);
    }

    public List<Element> findAllElements(By by) {
        return this.element.findElements(by)
                .stream()
                .map(el -> new Element(this.browserService, el))
                .collect(Collectors.toList());
    }

    public static List<Element> findAllElements(BrowserService browserService, By by) {
        var tmpUIElementObj = new Element(browserService);
        return tmpUIElementObj.findAllElements(by);
    }

    @Override
    public Element findElement(By by) {
        return new Element(this.browserService, this.element.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.element.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return this.element.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return this.element.getScreenshotAs(outputType);
    }

    public void hover() {
        actions.moveToElement(element)
                .build()
                .perform();
    }

    public Element getParent() {
        return this.findElement(By.xpath("./.."));
    }
}
