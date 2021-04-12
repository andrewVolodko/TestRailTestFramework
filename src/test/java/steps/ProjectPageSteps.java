package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import enums.ProjectMode;
import models.ProjectModel;
import pages.ProjectPage;

public class ProjectPageSteps extends BaseStep<ProjectPage> {

    public ProjectPageSteps(BrowserService browserService) {
        super(browserService, ProjectPage.class);
    }

    @Override
    public ProjectPageSteps openPage() {
        this.page.open();
        return this;
    }

    public AdminProjectsPageSteps addNewProject(ProjectModel project){
        this.page.getProjectNameInput().sendKeys(project.getName());
        this.page.getProjectAnnouncementsInput().sendKeys(project.getAnnouncement());
        this.page.setCheckboxState(this.page.getProjectShowAnnouncementsCheckbox(), project.isShowAnnouncement());
        var modeRadioBtn = switch (project.getProjectType()){
            case SINGLE_FOR_ALL_CASES -> this.page.getProjectSingleModeRadioBtn();
            case SINGLE_FOR_WITH_BASELINE -> this.page.getProjectSingleBaselineModeRadioBtn();
            case MULTIPLE -> this.page.getProjectMultiModeRadioBtn();
        };
        modeRadioBtn.click();
        this.page.getAddProjectBtn().click();
        return new AdminProjectsPageSteps(this.browserService);
    }

    public AdminProjectsPageSteps editProject(ProjectModel project){
        this.page.getProjectNameInput().clear();
        this.page.getProjectAnnouncementsInput().clear();
        return this.addNewProject(project);
    }

    public ProjectModel getProjectData(){
        return new ProjectModel(
                this.page.getProjectNameInput().getAttribute("value"),
                this.page.getProjectAnnouncementsInput().getAttribute("value"),
                this.page.getProjectShowAnnouncementsCheckbox().isSelected(),
                ProjectMode.getEnumByValue(this.page.getSelectedProjectMode().getAttribute("value")))
                .setIsCompleted(this.page.getCompletedProjectCheckboxBy().isSelected());
    }
}
