package pages;

import core.BrowserService;
import models.AdminPageProjectRowContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.common.CommonHeader;
import wrappers.Element;

public class AdminProjectsPage extends CommonHeader {

    // Locators
    private static final By projectsPageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Projects')]");
    private static final String projectRowLocator = "//a[text()='%projectName%']/ancestor::tr";
    private static final By projectNameLinkBy = By.xpath("//td/a[normalize-space()]");
    private static final By projectEditBtnBy = By.className("icon-small-edit");
    private static final By projectDeleteBtnBy = By.className("icon-small-delete");

    @FindBy(className = "message-success")
    public Element successProjectCRUDMessage;

    public AdminProjectsPage(BrowserService browserService) {
        super(browserService, "/admin/projects/overview");
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return projectsPageTitleBy;
    }

    public AdminPageProjectRowContainer getProjectRowByName(String projectName) {
        var projectRow = new Element(this.browserService, By.xpath(projectRowLocator.replace("%projectName%", projectName)));
        var projectNameLinkEl = projectRow.findElement(projectNameLinkBy);
        var projectEditBtnEl = projectRow.findElement(projectEditBtnBy);
        var projectDeleteBtnEl = projectRow.findElement(projectDeleteBtnBy);
        return new AdminPageProjectRowContainer(projectNameLinkEl, projectEditBtnEl, projectDeleteBtnEl);
    }
}
