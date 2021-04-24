package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Checkbox {
    private final UIElement element;

    public Checkbox(BrowserService browserService, By by) {
        this.element = new UIElement(browserService, by);
    }

    public Checkbox(UIElement uiElement) {
        this.element = uiElement;
    }

    public void changeState(boolean makeSelected) {
        if (this.isSelected() != makeSelected) this.click();
    }

    public boolean isSelected() {
        return this.element.isSelected();
    }

    public void click() {
        this.element.click();
    }
}
