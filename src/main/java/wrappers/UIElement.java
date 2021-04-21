package wrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class UIElement implements WebElement {
    private final WebDriver driver;
    private final WebElement element;
    private final Actions actions;
    private final JavascriptExecutor jsExecutor;
    private final Waiter waiter;


    public UIElement(WebDriver driver, By by) {
        this.driver = driver;
        this.element = this.driver.findElement(by);
        this.actions = new Actions(this.driver);
        this.jsExecutor = (JavascriptExecutor) this.driver;
        this.waiter = new Waiter(this.driver);
    }

    public UIElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
        this.actions = new Actions(this.driver);
        this.jsExecutor = (JavascriptExecutor) this.driver;
        this.waiter = new Waiter(this.driver);
    }

    public Checkbox castToCheckbox() {
        return new Checkbox(this);
    }

    public Button castToButton() {
        return new Button(this);
    }

    public RadioButtonInterface getRadioBtnInterface(By radioBtnLocator) {
        return new RadioButtonInterface(this, radioBtnLocator);
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
                jsExecutor.executeScript("arguments[0].click();", this.element);
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

    public List<UIElement> findUIElements(By by) {
        return this.element.findElements(by)
                .stream()
                .map(el -> new UIElement(this.driver, el))
                .collect(Collectors.toList());
    }

    @Override
    public UIElement findElement(By by) {
        return new UIElement(this.driver, this.element.findElement(by));
    }

    @Override
    public boolean isDisplayed() {
        return waiter.waitForVisibility(this.element).isDisplayed();
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

    public UIElement getParent() {
        return this.findElement(By.xpath("./.."));
    }
}
