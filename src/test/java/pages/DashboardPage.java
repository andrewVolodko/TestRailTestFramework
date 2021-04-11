package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static final String PATH = "index.php?/dashboard";

    // Locators
    protected static final By sidebarProjectAddBtnBy = By.id("sidebar-projects-add");

    public DashboardPage(BrowserService browserService, boolean openByUrl) {
        super(browserService, openByUrl);
    }

    @Override
    public DashboardPage open() {
        this.driver.get(baseUrl + PATH);
        return this;
    }
    @Override
    protected By getPageOpenedIndicatorEl() {
        return sidebarProjectAddBtnBy;
    }

    public WebElement getSidebarProjectAddBtn(){
        return driver.findElement(sidebarProjectAddBtnBy);
    }
}
