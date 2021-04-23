package steps.projectOverviewPageSteps;
import core.BrowserService;
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

    public AddTestCasePageSteps openAddTestCasePage(){
        this.page.getSidebarAddTestCaseButton().click();
        return new AddTestCasePageSteps(this.browserService);
    }
}
