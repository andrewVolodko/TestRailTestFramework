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
        this.page.projectNameInput.sendKeys(projectData.getName());
        this.page.projectAnnouncementsInput.sendKeys(projectData.getAnnouncement());
        this.page.projectShowAnnouncementsCheckbox.changeState(projectData.isShowAnnouncement());
        this.page.projectModeRadioBtnInterface.click(projectData.getProjectMode().getValue());
    }
}
