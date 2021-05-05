package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkbox implements IElement {
    private final Element element;

    public Checkbox(BrowserService browserService, By by) {
        this.element = new Element(browserService, by);
    }

    public Checkbox(BrowserService browserService, WebElement element) {
        this.element = new Element(browserService, element);
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
