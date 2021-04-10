package baseEntities;

import core.BrowserService;
import core.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected BrowserService browserService;
    public String baseUrl;

    public BasePage(BrowserService browserService, boolean openByUrl) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        this.baseUrl = new PropertyReader().getUrl();

        if(openByUrl)
            this.open();

        this.waitUntilOpen();
    }

    public abstract BasePage open();

    protected abstract By getPageOpenedIndicatorEl();

    protected void waitUntilOpen() {
        var isPageOpened = browserService.getWait()
                .waitForVisibility(getPageOpenedIndicatorEl())
                .isDisplayed();

        if (!isPageOpened) {
            throw new AssertionError("Page was not opened");
        }

//        int secondsCount = 0;
//        boolean isPageOpenedIndicator = isPageOpened();
//        while (!isPageOpenedIndicator && secondsCount < 5){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            secondsCount++;
//            isPageOpenedIndicator = isPageOpened();
//        }


    }
}
