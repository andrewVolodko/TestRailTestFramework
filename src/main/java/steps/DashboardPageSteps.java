package steps;

import core.BrowserService;
import enums.ProjectSummaryLink;
import pages.DashboardPage;
import steps.commonSteps.CommonHeaderSteps;
import steps.projectOverviewPageSteps.TestCasesTabSteps;
import steps.crudProjectPagesSteps.AddProjectPageSteps;

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

    public TestCasesTabSteps openProjectTestCasesTabByProjName(String projectName){
        this.clickProjectSummaryLink(projectName, ProjectSummaryLink.TEST_CASES);
        return new TestCasesTabSteps(this.browserService);
    }

    private void clickProjectSummaryLink(String projectName, ProjectSummaryLink projectSummaryLink){
        this.page.getProjectRowByName(projectName)
                .getProjectSummaryLink(projectSummaryLink)
                .click();
    }
}
