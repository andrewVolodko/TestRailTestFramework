package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import models.ProjectModel;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.AdminProjectsPageSteps;
import steps.DashboardPageSteps;
import steps.LoginPageSteps;
import testData.StaticDataProvider;
import utils.Randomizer;


public class ProjectCRUDTest extends BaseTestWithClassDriverInitialization {

    private final ProjectModel curProjectData;

    private DashboardPageSteps dashboardPageSteps;
    private AdminProjectsPageSteps adminProjectsPageSteps;

    @Factory(dataProvider = "projectDataProvider", dataProviderClass = StaticDataProvider.class)
    public ProjectCRUDTest(ProjectModel projectData) {
        this.curProjectData = projectData;
    }

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void login(String email, String password) {
        this.dashboardPageSteps = new LoginPageSteps(browserService)
                .openPage()
                .loginWithCorrectCreds(email, password);
    }

    @Test
    public void addProjectTest() {
        this.adminProjectsPageSteps = this.dashboardPageSteps
                .openAddProjectPage()
                .addNewProject(curProjectData);

        var createdProjectNameLink = this.adminProjectsPageSteps
                .getPageInstance()
                .getProjectRowByName(curProjectData.getName())
                .getProjectNameLink();
        Assert.assertTrue(createdProjectNameLink.isDisplayed());
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void editProjectTest() {
        var editedProject = this.adminProjectsPageSteps
                .openEditProjectPageByName(curProjectData.getName())
                .editProject(curProjectData.setName(Randomizer.getRandomString(10)))
                .openEditProjectPageByName(curProjectData.getName())
                .getProjectData();

        Assert.assertEquals(editedProject, curProjectData);
    }

    @Test(dependsOnMethods = "editProjectTest")
    public void deleteProjectTest(){
        var adminProjectsPageSteps = new AdminProjectsPageSteps(browserService).openPage();
        var adminProjectsPage = adminProjectsPageSteps
                .deleteProjectByName(curProjectData.getName())
                .getPageInstance();

        Assert.assertFalse(adminProjectsPageSteps.isProjectExisted(curProjectData.getName()));
        Assert.assertEquals(adminProjectsPage.getSuccessProjectCRUDMessage().getText(),
                "Successfully deleted the project.");
    }
}