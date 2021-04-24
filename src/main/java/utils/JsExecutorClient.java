package utils;

import core.BrowserService;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsExecutorClient {
    private final JavascriptExecutor executor;

    private JsExecutorClient(JavascriptExecutor executor){
        this.executor = executor;
    }

    public static JsExecutorClient get(BrowserService browserService) {
        return new JsExecutorClient((JavascriptExecutor) browserService.getDriver());
    }

    public Object getAllAttributes(WebElement element) {
        return this.executor
                .executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
                        element);
    }

    public void clickOnElement(WebElement element){
        this.executor.executeScript("arguments[0].click();", element);
    }
}
