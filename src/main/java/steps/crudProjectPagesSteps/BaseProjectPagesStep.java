package steps.crudProjectPagesSteps;

import core.BrowserService;
import io.qameta.allure.Step;
import models.ProjectModel;
import pages.crudProjectPages.BaseProjectPage;
import steps.commonSteps.CommonHeaderSteps;

public abstract class BaseProjectPagesStep<T extends BaseProjectPage> extends CommonHeaderSteps<T> {
    public BaseProjectPagesStep(BrowserService browserService, Class<T> pageClass) {
        super(browserService, pageClass);
    }

    @Step("Fill Project Data")
    protected void fillProjectData(ProjectModel projectData) {
        this.page.getProjectNameInput().sendKeys(projectData.getName());
        this.page.getProjectAnnouncementsInput().sendKeys(projectData.getAnnouncement());
        this.page.getProjectShowAnnouncementsCheckbox().changeState(projectData.isShowAnnouncement());
        this.page.getProjectModeRadioBtnInterface().click(projectData.getProjectType().getValue());
    }
}
