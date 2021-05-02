package utils;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.UIElement;

public class Waiter {
    private final BrowserService browserService;
    private final WebDriverWait wait;

    public Waiter(BrowserService browserService, int timeOut) {
        this.browserService = browserService;
        this.wait = new WebDriverWait(this.browserService.getDriver(), timeOut);
    }

    public Waiter(BrowserService browserService) {
        this(browserService, new PropertyReader().getTimeOut());
    }

    public UIElement waitForVisibility(By by){
        return new UIElement(this.browserService, this.wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public UIElement waitForVisibility(WebElement element){
        return new UIElement(this.browserService, this.wait.until(ExpectedConditions.visibilityOf(element)));
    }
}
