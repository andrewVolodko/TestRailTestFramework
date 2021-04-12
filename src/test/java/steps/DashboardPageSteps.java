package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.DashboardPage;

public class DashboardPageSteps extends BaseStep<DashboardPage> {

    public DashboardPageSteps(BrowserService browserService) {
        super(browserService, DashboardPage.class);
    }

    @Override
    public DashboardPageSteps openPage() {
        this.page.open();
        return this;
    }

    public ProjectPageSteps openAddProjectPage(){
        this.page.getSidebarProjectAddBtn().click();
        return new ProjectPageSteps(this.browserService);
    }

}
