package pages;

import core.BrowserService;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.Button;

public class DashboardPage extends CommonHeader {
    private static final String PATH = "/dashboard";

    // Locators
    private static final By sidebarProjectAddBtnBy = By.id("sidebar-projects-add");
    private static final By projectRowBy = By.xpath("//a[.='%projectName%']/ancestor::div[contains(@class, 'flex-projects-row')]");


    public DashboardPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return sidebarProjectAddBtnBy;
    }

    public Button getSidebarProjectAddBtn() {
        return new Button(this.driver, sidebarProjectAddBtnBy);
    }


}
