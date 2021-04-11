package steps;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import core.BrowserService;
import models.ProjectModel;
import pages.AddProjectPage;

public class AddProjectPageSteps extends BaseStep {
    public AddProjectPageSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public BasePage getPageInstance(boolean openByUrl) {
        return new AddProjectPage(browserService, openByUrl);
    }

    public AdminProjectsPageSteps addNewProject(ProjectModel project){
        var addProjectPage = new AddProjectPage(browserService, false);
        addProjectPage.getProjectNameInput().sendKeys(project.getName());
        addProjectPage.getProjectAnnouncementsInput().sendKeys(project.getAnnouncement());
        if(project.isShowAnnouncement())
            addProjectPage.getProjectShowAnnouncementsCheckbox().click();
        var modeRadioBtn = switch (project.getProjectType()){
            case SINGLE_FOR_ALL_CASES -> addProjectPage.getProjectSingleModeRadioBtn();
            case SINGLE_FOR_WITH_BASELINE -> addProjectPage.getProjectSingleBaselineModeRadioBtn();
            case MULTIPLE -> addProjectPage.getProjectMultiModeRadioBtn();
        };
        modeRadioBtn.click();
        addProjectPage.getAddProjectBtn().click();
        return new AdminProjectsPageSteps(browserService);
    }
}
