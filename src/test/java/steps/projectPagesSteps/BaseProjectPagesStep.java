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

        var modeRadioBtn = switch (projectData.getProjectType()) {
            case SINGLE_FOR_ALL_CASES -> this.page.getProjectSingleModeRadioBtn();
            case SINGLE_FOR_WITH_BASELINE -> this.page.getProjectSingleBaselineModeRadioBtn();
            case MULTIPLE -> this.page.getProjectMultiModeRadioBtn();
        };
        modeRadioBtn.click();
    }
}
