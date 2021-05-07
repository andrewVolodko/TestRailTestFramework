package steps.projectOverviewPageSteps;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.projectOverviewPage.TestCasesTab;
import steps.commonSteps.CommonHeaderSteps;
import steps.crudTestCasePagesSteps.AddTestCasePageSteps;

public class TestCasesTabSteps extends CommonHeaderSteps<TestCasesTab> {
    public TestCasesTabSteps(BrowserService browserService) {
        super(browserService, TestCasesTab.class);
    }

    @Override
    public TestCasesTabSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Open Add Test Case Page")
    public AddTestCasePageSteps openAddTestCasePage(){
        this.page.sidebarAddTestCaseBtn.click();
        return new AddTestCasePageSteps(this.browserService);
    }
}
