package steps.crudProjectPagesSteps;

import core.BrowserService;
import io.qameta.allure.Step;
import models.ProjectModel;
import pages.crudProjectPages.BaseProjectPage;
import steps.commonSteps.CommonHeaderSteps;

public abstract class BaseProjectPagesSteps<T extends BaseProjectPage> extends CommonHeaderSteps<T> {
    public BaseProjectPagesSteps(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Step("Fill Project Data")
    protected void fillProjectData(ProjectModel projectData) {
        this.page.getProjectNameInput().sendKeys(projectData.getName());
        this.page.getProjectAnnouncementsInput().sendKeys(projectData.getAnnouncement());
        this.page.getProjectShowAnnouncementsCheckbox().changeState(projectData.isShowAnnouncement());
        this.page.getProjectModeRadioBtnInterface().click(projectData.getProjectMode());
    }
}
