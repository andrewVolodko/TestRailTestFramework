package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    private final UIElement element;

    public Checkbox(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
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

    public void click(){
        this.element.click();
    }
}
