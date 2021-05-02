package steps.crudProjectPagesSteps;

import core.BrowserService;
import enums.ProjectMode;
import io.qameta.allure.Step;
import models.ProjectModel;
import pages.crudProjectPages.EditProjectPage;
import steps.AdminProjectsPageSteps;

public class EditProjectPageSteps extends BaseProjectPagesStep<EditProjectPage> {
    public EditProjectPageSteps(BrowserService browserService) {
        super(browserService, EditProjectPage.class);
    }

    @Override
    public EditProjectPageSteps openPage() {
        this.page.open();
        return this;
    }

    public AdminProjectsPageSteps editProject(ProjectModel project) {
        this.page.getProjectNameInput().clear();
        this.page.getProjectAnnouncementsInput().clear();
        this.fillProjectData(project);
        this.page.getCompletedProjectCheckboxBy().changeState(project.getIsCompleted());
        this.page.getAddProjectBtn().click();
        return new AdminProjectsPageSteps(this.browserService);
    }

    @Step("Collect Project Data")
    public ProjectModel collectProjectData() {
        return new ProjectModel(
                this.page.getProjectNameInput().getAttribute("value"),
                this.page.getProjectAnnouncementsInput().getAttribute("value"),
                this.page.getProjectShowAnnouncementsCheckbox().isSelected(),
                ProjectMode.getEnumByValue(this.page.getProjectModeRadioBtnInterface()
                        .getSelectedRadioButton()
                        .getInput()
                        .getAttribute("value")))
                .setIsCompleted(this.page.getCompletedProjectCheckboxBy().isSelected());
    }
}
