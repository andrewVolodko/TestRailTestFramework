package steps.crudProjectPagesSteps;

import core.BrowserService;
import io.qameta.allure.Step;
import models.ProjectModel;
import pages.crudProjectPages.AddProjectPage;
import steps.AdminProjectsPageSteps;

public class AddProjectPageSteps extends BaseProjectPagesSteps<AddProjectPage> {

    public AddProjectPageSteps(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    public AddProjectPageSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Add Project")
    public AdminProjectsPageSteps addNewProject(ProjectModel project) {
        this.fillProjectData(project);
        this.page.getSubmitProjectBtn().click();
        return new AdminProjectsPageSteps(this.browserService, false);
    }
}
