package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.DashboardPage;

public class DashboardPageSteps extends BaseStep {
    public DashboardPageSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public DashboardPage getPageInstance(boolean openByUrl) {
        return new DashboardPage(browserService, openByUrl);
    }

    public AddProjectPageSteps openAddProjectPage(){
        new DashboardPage(browserService, false).getSidebarProjectAddBtn().click();
        return new AddProjectPageSteps(browserService);
    }
}
