package newWrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element extends AbstractElement{
    public Element(BrowserService browserService, WebElement element) {
        super(browserService, element);
    }

    public Element(BrowserService browserService, By by) {
        super(browserService, by);
    }

    public void sendKeys(CharSequence... charSequences) {
        this.element.sendKeys(charSequences);
    }

    public String getText() {
        return this.element.getText();
    }

    public void hover() {
        this.actions
                .moveToElement(this.element)
                .build()
                .perform();
    }
}
