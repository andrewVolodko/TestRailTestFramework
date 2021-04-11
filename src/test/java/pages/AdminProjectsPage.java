package pages;

import baseEntities.BasePage;
import core.BrowserService;
import models.ProjectRowModel;
import org.openqa.selenium.By;

public class AdminProjectsPage extends BasePage {
    private static final String PATH = "index.php?/admin/projects/overview";

    private static final By projectsPageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Projects')]");
    private static final String projectRowLocator = "//a[text()='%projectName%']/ancestor::tr";
    private static final By projectNameLinkBy = By.xpath("//td/a[normalize-space()]");
    private static final By projectEditBtnBy = By.className("icon-small-edit");
    private static final By projectDeleteBtnBy = By.className("icon-small-delete");

    public AdminProjectsPage(BrowserService browserService, boolean openByUrl) {
        super(browserService, openByUrl);
    }

    @Override
    public BasePage open() {
        driver.get(baseUrl + PATH);
        return this;
    }

    @Override
    protected By getPageOpenedIndicatorEl() {
        return projectsPageTitleBy;
    }

    public ProjectRowModel getProjectRowByName(String projectName){
        var projectRow = driver.findElement(By.xpath(projectRowLocator.replace("%projectName%", projectName)));
        var projectNameLinkEl = projectRow.findElement(projectNameLinkBy);
        var projectEditBtnEl = projectRow.findElement(projectEditBtnBy);
        var projectDeleteBtnEl = projectRow.findElement(projectDeleteBtnBy);
        return new ProjectRowModel(projectNameLinkEl, projectEditBtnEl, projectDeleteBtnEl);
    }
}
