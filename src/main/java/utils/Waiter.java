package utils;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.Element;

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

    public Element waitForVisibility(By by){
        return new Element(this.browserService, this.wait.until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public Element waitForVisibility(Element element){
        return new Element(this.browserService, this.wait.until(ExpectedConditions.visibilityOf(element.getWebElement())));
    }
}
