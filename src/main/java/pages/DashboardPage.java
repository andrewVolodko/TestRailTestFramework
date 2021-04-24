package pages;

import core.BrowserService;
import models.DashboardPageProjectRowContainer;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.Button;
import wrappers.UIElement;

public class DashboardPage extends CommonHeader {
    private static final String PATH = "/dashboard";

    // Locators
    private static final By sidebarProjectAddBtnBy = By.id("sidebar-projects-add");
    private static final String projectRowLocator = "//a[.='%projectName%']/ancestor::div[contains(@class, 'flex-projects-row')]";
    private static final By projectNameLinkBy = By.xpath("//a[contains(@href, 'projects/overview')]");
    private static final By projectSummaryLinks = By.cssSelector(".summary-links a");

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
        return new Button(this.browserService, sidebarProjectAddBtnBy);
    }

    public DashboardPageProjectRowContainer getProjectRowByName(String projectName){
        var projectRow = new UIElement(this.browserService, By.xpath(projectRowLocator.replace("%projectName%", projectName)));
        var projectNameLinkEl = projectRow.findElement(projectNameLinkBy);
        var projectSummaryLinkEls = projectRow.findUIElements(projectSummaryLinks);
        return new DashboardPageProjectRowContainer(projectNameLinkEl, projectSummaryLinkEls);
    }

}
