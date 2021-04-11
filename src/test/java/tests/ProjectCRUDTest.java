package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import enums.ProjectType;
import models.ProjectModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.DashboardPageSteps;
import steps.LoginPageSteps;

public class ProjectCRUDTest extends BaseTestWithClassDriverInitialization {

    private DashboardPageSteps dashboardPageSteps;

    @DataProvider(name = "projectDataProvider")
    public Object[][] dataProvider(){
        return new ProjectModel[][] {
                { new ProjectModel("123123TestProjectName", "", true, ProjectType.MULTIPLE)}
        };
    }

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void login(String email, String password){
        this.dashboardPageSteps = new LoginPageSteps(browserService).loginWithCorrectCreds(email, password);
    }

    @Test(dataProvider = "projectDataProvider")
    public void addProjectTest(ProjectModel project) {
        var adminProjectsPage = this.dashboardPageSteps
                .openAddProjectPage()
                .addNewProject(project)
                .getPageInstance(false);

        Assert.assertTrue(adminProjectsPage.getProjectRowByName(project.getName()).getProjectNameLink().isDisplayed());
    }

}
