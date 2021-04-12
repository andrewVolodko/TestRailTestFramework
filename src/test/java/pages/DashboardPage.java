package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static final String PATH = "index.php?/dashboard";

    // Locators
    protected static final By sidebarProjectAddBtnBy = By.id("sidebar-projects-add");

    public DashboardPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(baseUrl + PATH);
        super.open();
    }
    @Override
    protected By getPageOpenedIndicatorEl() {
        return sidebarProjectAddBtnBy;
    }

    public WebElement getSidebarProjectAddBtn(){
        return driver.findElement(sidebarProjectAddBtnBy);
    }
}
