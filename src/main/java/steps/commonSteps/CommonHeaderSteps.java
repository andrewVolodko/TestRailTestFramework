package steps.commonSteps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.common.CommonHeader;
import steps.DashboardPageSteps;

public abstract class CommonHeaderSteps<T extends CommonHeader> extends BaseStep<T> {

    public CommonHeaderSteps(BrowserService browserService, Class<T> pageClass) {
        super(browserService, pageClass);
    }

    @Step("Select Dashboard Tab")
    public DashboardPageSteps goToDashboardTab() {
        this.page.getDashboardTabBtn().click();
        return new DashboardPageSteps(browserService);
    }
}
