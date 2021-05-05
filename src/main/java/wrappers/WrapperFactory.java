package wrappers;

import core.BrowserService;
import org.openqa.selenium.WebElement;

public class WrapperFactory {

    public static IElement createInstance(Class<IElement> clazz, BrowserService browserService, WebElement element) {
        try {
            return clazz.getConstructor(BrowserService.class, WebElement.class).newInstance(browserService, element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz +
                            ". Wrapper class must contain constructor with BrowserService and WebElement arguments"
            );
        }
    }
}
