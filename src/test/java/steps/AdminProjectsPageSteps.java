package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.AdminProjectsPage;

public class AdminProjectsPageSteps extends BaseStep<AdminProjectsPage> {

    public AdminProjectsPageSteps(BrowserService browserService) {
        super(browserService, AdminProjectsPage.class);
    }

    @Override
    public AdminProjectsPageSteps openPage() {
        this.page.open();
        return this;
    }

    public ProjectPageSteps openEditProjectPageByName(String projectName){
        this.page.getProjectRowByName(projectName).getProjectEditBtn().click();
        return new ProjectPageSteps(this.browserService);
    }
}