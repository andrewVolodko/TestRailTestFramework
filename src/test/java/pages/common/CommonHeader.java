package pages.common;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.UIElement;

public abstract class CommonHeader extends BasePage {
    // Locators
    private static final By dashboardTabBtnBy = By.id("navigation-dashboard");

    public CommonHeader(BrowserService browserService) {
        super(browserService);
    }

    public UIElement getDashboardTabBtn(){
        return new UIElement(this.driver, dashboardTabBtnBy);
    }
}
