package utils;

import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private final WebDriverWait wait;

    public Waiter(WebDriver driver, int timeOut) {
        this.wait = new WebDriverWait(driver, timeOut);
    }

    public Waiter(WebDriver driver) {
        this(driver, new PropertyReader().getTimeOut());
    }

    public WebElement waitForVisibility(By by){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisibility(WebElement element){
        return this.wait.until(ExpectedConditions.visibilityOf(element));
    }
}
