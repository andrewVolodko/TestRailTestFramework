package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.AdminProjectsPage;

public class AdminProjectsPageSteps extends BaseStep {
    public AdminProjectsPageSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public AdminProjectsPage getPageInstance(boolean openByUrl) {
        return new AdminProjectsPage(browserService, openByUrl);
    }


}
