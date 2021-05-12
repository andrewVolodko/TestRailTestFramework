package steps.projectOverviewPageSteps;

import core.BrowserService;
import pages.projectDetailsPage.ProjectOverviewTab;

public class ProjectOverviewTabSteps extends ProjectDetailsPageHeaderSteps<ProjectOverviewTab> {
    public ProjectOverviewTabSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public ProjectOverviewTabSteps openPage() {
        return this;
    }

    public ProjectOverviewTabSteps openProjectOverviewPageByProjId(int projectId){
        this.page.openProjectOverviewPageByProjId(projectId);
        return this;
    }
}
