package steps.projectPagesSteps;

import core.BrowserService;
import models.ProjectModel;
import pages.projectPages.BaseProjectPage;
import steps.commonSteps.CommonHeaderSteps;

public abstract class BaseProjectPagesStep<T extends BaseProjectPage> extends CommonHeaderSteps<T> {
    public BaseProjectPagesStep(BrowserService browserService, Class<T> pageClass) {
        super(browserService, pageClass);
    }

    protected void fillProjectData(ProjectModel projectData) {
        this.page.getProjectNameInput().sendKeys(projectData.getName());
        this.page.getProjectAnnouncementsInput().sendKeys(projectData.getAnnouncement());
        this.page.getProjectShowAnnouncementsCheckbox().changeState(projectData.isShowAnnouncement());
        this.page.getProjectModeRadioBtnInterface().click(projectData.getProjectType().getValue());
    }
}
