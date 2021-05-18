package steps.projectOverviewPageSteps;

import core.BrowserService;
import io.qameta.allure.Step;
import pages.projectDetailsPage.ProjectOverviewTab;

public class ProjectOverviewTabSteps extends ProjectDetailsPageHeaderSteps<ProjectOverviewTab> {
    public ProjectOverviewTabSteps(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    public ProjectOverviewTabSteps openPage() { return this; }

    @Step("Open Project Overview Page By Project Id")
    public ProjectOverviewTabSteps openPage(int projectId) {
        this.page.openProjectOverviewPageByProjId(projectId);
        return this;
    }
}
