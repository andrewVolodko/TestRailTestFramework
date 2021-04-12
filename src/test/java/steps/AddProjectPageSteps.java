package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import models.ProjectModel;
import pages.AddProjectPage;

public class AddProjectPageSteps extends BaseStep<AddProjectPage> {

    public AddProjectPageSteps(BrowserService browserService) {
        super(browserService, AddProjectPage.class);
    }

    @Override
    public AddProjectPageSteps openPage() {
        this.page.open();
        return this;
    }

    public AdminProjectsPageSteps addNewProject(ProjectModel project){
        var addProjectPage = new AddProjectPage(browserService);
        this.page.getProjectNameInput().sendKeys(project.getName());
        this.page.getProjectAnnouncementsInput().sendKeys(project.getAnnouncement());
        if(project.isShowAnnouncement())
            this.page.getProjectShowAnnouncementsCheckbox().click();
        var modeRadioBtn = switch (project.getProjectType()){
            case SINGLE_FOR_ALL_CASES -> this.page.getProjectSingleModeRadioBtn();
            case SINGLE_FOR_WITH_BASELINE -> this.page.getProjectSingleBaselineModeRadioBtn();
            case MULTIPLE -> this.page.getProjectMultiModeRadioBtn();
        };
        modeRadioBtn.click();
        this.page.getAddProjectBtn().click();
        return new AdminProjectsPageSteps(browserService);
    }
}
