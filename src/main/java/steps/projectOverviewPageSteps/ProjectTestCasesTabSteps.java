package steps.projectOverviewPageSteps;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.projectDetailsPage.ProjectTestCasesTab;
import steps.crudTestCasePagesSteps.AddTestCasePageSteps;

public class ProjectTestCasesTabSteps extends ProjectDetailsPageHeaderSteps<ProjectTestCasesTab> {
    public ProjectTestCasesTabSteps(BrowserService browserService) {
        super(browserService, false);
    }

    @Override
    public ProjectTestCasesTabSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Open Add Test Case Page")
    public AddTestCasePageSteps openAddTestCasePage(){
        this.page.getSidebarAddTestCaseButton().click();
        return new AddTestCasePageSteps(this.browserService);
    }
}
