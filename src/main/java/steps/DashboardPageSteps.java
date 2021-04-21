package steps;

import core.BrowserService;
import pages.DashboardPage;
import steps.commonSteps.CommonHeaderSteps;
import steps.projectPagesSteps.AddProjectPageSteps;

public class DashboardPageSteps extends CommonHeaderSteps<DashboardPage> {

    public DashboardPageSteps(BrowserService browserService) {
        super(browserService, DashboardPage.class);
    }

    @Override
    public DashboardPageSteps openPage() {
        this.page.open();
        return this;
    }

    public AddProjectPageSteps openAddProjectPage() {
        this.page.getSidebarProjectAddBtn().click();
        return new AddProjectPageSteps(this.browserService);
    }

}
