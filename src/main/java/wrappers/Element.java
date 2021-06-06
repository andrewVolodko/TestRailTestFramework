package wrappers;

import core.BrowserService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.JsExecutorClient;
import utils.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class Element implements WebElement {
    private final BrowserService browserService;
    private final WebElement webElement;
    private final Actions actions;
    private final JsExecutorClient jsExecutorClient;
    private final Waiter waiter;

    public Element(BrowserService browserService, By by) {
        this.browserService = browserService;
        this.webElement = browserService.getDriver().findElement(by);
        this.actions = new Actions(browserService.getDriver());
        this.jsExecutorClient = JsExecutorClient.get(browserService);
        this.waiter = browserService.getWait();
    }

    public Element(BrowserService browserService, WebElement webElement) {
        this.browserService = browserService;
        this.webElement = webElement;
        this.actions = new Actions(browserService.getDriver());
        this.jsExecutorClient = JsExecutorClient.get(browserService);
        this.waiter = browserService.getWait();
    }

    private Element(BrowserService browserService){
        this(browserService, browserService.getDriver().findElement(By.xpath("//*")));
    }

    public Checkbox castToCheckbox() {
        return new Checkbox(this.browserService, this.webElement);
    }

    public Button castToButton() {
        return new Button(this.browserService, this.webElement);
    }

    public WebElement getWebElement() {
        return this.webElement;
    }

    @Override
    public void click() {
        try {
            this.webElement.click();
        } catch (Exception ex) {
            try {
                actions.moveToElement(this.webElement)
                        .click()
                        .build()
                        .perform();
            } catch (Exception ex1) {
                jsExecutorClient.clickOnElement(this.webElement);
            }
        }
    }

    @Override
    public void submit() {
        this.webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        this.webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        this.webElement.clear();
    }

    @Override
    public String getTagName() {
        return this.webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return this.webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return this.webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return this.webElement.isEnabled();
    }

    @Override
    public String getText() {
        return this.webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return this.webElement.findElements(by);
    }

    public List<Element> findAllElements(By by) {
        return this.webElement.findElements(by)
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
        return new Element(this.browserService, this.webElement.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return this.webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return this.webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return this.webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return this.webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return this.webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return this.webElement.getScreenshotAs(outputType);
    }

    public void hover() {
        actions.moveToElement(webElement)
                .build()
                .perform();
    }

    public Element getParent() {
        return this.findElement(By.xpath("./.."));
    }
}
