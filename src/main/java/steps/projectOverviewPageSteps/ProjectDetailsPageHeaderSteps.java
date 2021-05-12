package steps.projectOverviewPageSteps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.projectDetailsPage.ProjectDetailsPageHeader;

public abstract class ProjectDetailsPageHeaderSteps<T extends ProjectDetailsPageHeader> extends BaseStep<T> {

    public ProjectDetailsPageHeaderSteps(BrowserService browserService, Class<T> pageClass) {
        super(browserService, pageClass);
    }
}
