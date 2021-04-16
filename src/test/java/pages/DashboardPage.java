package pages;

import core.BrowserService;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.UIElement;

public class DashboardPage extends CommonHeader {
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

    public UIElement getSidebarProjectAddBtn() {
        return new UIElement(this.driver, sidebarProjectAddBtnBy);
    }
}
