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
        this.page.projectNameInput.clear();
        this.page.projectAnnouncementsInput.clear();
        this.fillProjectData(project);
        this.page.completedProjectCheckbox.changeState(project.getIsCompleted());
        this.page.addProjectBtn.click();
        return new AdminProjectsPageSteps(this.browserService);
    }

    @Step("Collect Project Data")
    public ProjectModel collectProjectData() {
        return new ProjectModel(
                this.page.projectNameInput.getAttribute("value"),
                this.page.projectAnnouncementsInput.getAttribute("value"),
                this.page.projectShowAnnouncementsCheckbox.isSelected(),
                ProjectMode.getEnumByValue(this.page.projectModeRadioBtnInterface
                        .getSelectedRadioButton()
                        .getInput()
                        .getAttribute("value")))
                .setIsCompleted(this.page.completedProjectCheckbox.isSelected());
    }
}
