package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends ElementWrapper {
//    private final Element element;

    public Button(BrowserService browserService, By by) {
        super(browserService, by);
    }

    public Button(BrowserService browserService, WebElement element) {
        super(browserService, element);
    }

    public void click() {
        this.element.click();
    }

    public void submit() {
        this.element.submit();
    }

    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    public void hover() {
        this.element.hover();
    }
}
