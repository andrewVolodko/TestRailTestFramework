package utils;

import core.BrowserService;
import org.openqa.selenium.JavascriptExecutor;

public class JsExecutor {

    public static JavascriptExecutor get(BrowserService browserService){
        return (JavascriptExecutor) browserService.getDriver();
    }
}
