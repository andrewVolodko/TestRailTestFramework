package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class Checkbox {
    private final Element element;

    public Checkbox(BrowserService browserService, By by) {
        this.element = new Element(browserService, by);
    }

    public Checkbox(Element element) {
        this.element = element;
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
