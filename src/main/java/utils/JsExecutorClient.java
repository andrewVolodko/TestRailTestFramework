package utils;

import core.BrowserService;
import org.openqa.selenium.JavascriptExecutor;
import wrappers.UIElement;

public class JsExecutorClient {
    private final JavascriptExecutor executor;

    private JsExecutorClient(JavascriptExecutor executor){
        this.executor = executor;
    }

    public static JsExecutorClient get(BrowserService browserService) {
        return new JsExecutorClient((JavascriptExecutor) browserService.getDriver());
    }

    public Object getAllAttributes(UIElement element) {
        return this.executor
                .executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
                        element.getWebElement());
    }
}
