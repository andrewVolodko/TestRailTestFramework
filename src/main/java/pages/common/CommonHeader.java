package pages.common;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;

public abstract class CommonHeader extends BasePage {
    // Locators
    private static final By dashboardTabBtnBy = By.id("navigation-dashboard");

    public CommonHeader(BrowserService browserService) {
        super(browserService);
    }

    public Button getDashboardTabBtn() {
        return new Button(this.browserService, dashboardTabBtnBy);
    }
}
