package pages;

import core.BrowserService;
import models.AdminPageProjectRowContainer;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.UIElement;

public class AdminProjectsPage extends CommonHeader {
    private static final String PATH = "/admin/projects/overview";

    private static final By projectsPageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Projects')]");
    private static final String projectRowLocator = "//a[text()='%projectName%']/ancestor::tr";
    private static final By projectNameLinkBy = By.xpath("//td/a[normalize-space()]");
    private static final By projectEditBtnBy = By.className("icon-small-edit");
    private static final By projectDeleteBtnBy = By.className("icon-small-delete");
    private static final By successProjectCRUDMessageBy = By.className("message-success");

    public AdminProjectsPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return projectsPageTitleBy;
    }


    // Замена на использование обертки Table
    public AdminPageProjectRowContainer getProjectRowByName(String projectName) {
        var projectRow = new UIElement(this.driver, By.xpath(projectRowLocator.replace("%projectName%", projectName)));
        var projectNameLinkEl = projectRow.findElement(projectNameLinkBy);
        var projectEditBtnEl = projectRow.findElement(projectEditBtnBy);
        var projectDeleteBtnEl = projectRow.findElement(projectDeleteBtnBy);
        return new AdminPageProjectRowContainer(projectNameLinkEl, projectEditBtnEl, projectDeleteBtnEl);
    }

    public UIElement getSuccessProjectCRUDMessage() {
        return new UIElement(this.driver, successProjectCRUDMessageBy);
    }
}
