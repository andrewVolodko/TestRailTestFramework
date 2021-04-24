package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Button {
    private final UIElement element;

    public Button(BrowserService browserService, By by) {
        this.element = new UIElement(browserService, by);
    }

    public Button(UIElement uiElement) {
        this.element = uiElement;
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
