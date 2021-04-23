package steps.crudProjectPagesSteps;

import core.BrowserService;
import models.ProjectModel;
import pages.crudProjectPages.AddProjectPage;
import steps.AdminProjectsPageSteps;

public class AddProjectPageSteps extends BaseProjectPagesStep<AddProjectPage> {

    public AddProjectPageSteps(BrowserService browserService) {
        super(browserService, AddProjectPage.class);
    }

    @Override
    public AddProjectPageSteps openPage() {
        this.page.open();
        return this;
    }

    public AdminProjectsPageSteps addNewProject(ProjectModel project) {
        this.fillProjectData(project);
        this.page.getAddProjectBtn().click();
        return new AdminProjectsPageSteps(this.browserService);
    }
}
