package newWrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends AbstractElement {
    public Button(BrowserService browserService, WebElement element) {
        super(browserService, element);
    }

    public Button(BrowserService browserService, By by) {
        super(browserService, by);
    }


}
