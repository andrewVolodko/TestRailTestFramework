package pages;

import core.BrowserService;
import models.DashboardPageProjectRowContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.common.CommonHeader;
import wrappers.Button;
import wrappers.Element;

public class DashboardPage extends CommonHeader {

    // Locators
    private static final String projectRowLocator = "//a[.='%projectName%']/ancestor::div[contains(@class, 'flex-projects-row')]";
    private static final By projectNameLinkBy = By.xpath("//a[contains(@href, 'projects/overview')]");
    private static final By projectSummaryLinks = By.cssSelector(".summary-links a");

    @FindBy(id = "sidebar-projects-add")
    public Button sidebarProjectAddBtn;

    public DashboardPage(BrowserService browserService) {
        super(browserService, "/dashboard");
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return By.id("sidebar-projects-add");
    }

    public DashboardPageProjectRowContainer getProjectRowByName(String projectName) {
        var projectRow = new Element(this.browserService, By.xpath(projectRowLocator.replace("%projectName%", projectName)));
        var projectNameLinkEl = projectRow.findElement(projectNameLinkBy);
        var projectSummaryLinkEls = projectRow.findAllElements(projectSummaryLinks);
        return new DashboardPageProjectRowContainer(projectNameLinkEl, projectSummaryLinkEls);
    }

}
