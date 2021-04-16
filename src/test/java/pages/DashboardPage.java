package pages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.common.CommonHeader;

public class DashboardPage extends CommonHeader {
    private static final String PATH = "index.php?/dashboard";

    // Locators
    protected static final By sidebarProjectAddBtnBy = By.id("sidebar-projects-add");
    private static final String projectRowLocator = "//a[text()='%projectName%']/ancestor::tr";

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

    public WebElement getSidebarProjectAddBtn() {
        return driver.findElement(sidebarProjectAddBtnBy);
    }
}
