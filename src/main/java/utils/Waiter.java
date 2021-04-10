package utils;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private final WebDriverWait wait;

    public Waiter(BrowserService browserService, int timeOut) {
        this.wait = new WebDriverWait(browserService.getDriver(), timeOut);
    }

    public Waiter(BrowserService browserService) {
        this(browserService, new PropertyReader().getTimeOut());
    }

    public WebElement waitForVisibility(By by){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
