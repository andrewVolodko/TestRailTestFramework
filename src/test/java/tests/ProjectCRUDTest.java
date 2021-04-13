package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import enums.ProjectMode;
import models.ProjectModel;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.AdminProjectsPageSteps;
import steps.DashboardPageSteps;
import steps.LoginPageSteps;
import testData.StaticDataProvider;


public class ProjectCRUDTest extends BaseTestWithClassDriverInitialization {

    private String projectName;

    private DashboardPageSteps dashboardPageSteps;
    private AdminProjectsPageSteps adminProjectsPageSteps;

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void login(String email, String password) {
        this.dashboardPageSteps = new LoginPageSteps(browserService)
                .openPage()
                .loginWithCorrectCreds(email, password);
    }

    @Test(dataProvider = "projectDataProvider", dataProviderClass = StaticDataProvider.class)
    public void addProjectTest(ProjectModel project) {
        this.adminProjectsPageSteps = this.dashboardPageSteps
                .openAddProjectPage()
                .addNewProject(project);

        var createdProjectNameLink = this.adminProjectsPageSteps
                .getPageInstance()
                .getProjectRowByName(project.getName())
                .getProjectNameLink();
        Assert.assertTrue(createdProjectNameLink.isDisplayed());

        this.projectName = project.getName();
    }

    @Test(dependsOnMethods = "addProjectTest", dataProvider = "projectDataProvider", dataProviderClass = StaticDataProvider.class)
    public void editProjectTest(ProjectModel project) {
        var editedProject = this.adminProjectsPageSteps
                .openEditProjectPageByName(this.projectName)
                .editProject(project)
                .openEditProjectPageByName(project.getName())
                .getProjectData();

        Assert.assertEquals(editedProject, project);

        this.projectName = project.getName();
    }

    @Test(dependsOnMethods = "editProjectTest")
    public void deleteProjectTest(){
        var adminProjectsPageSteps = new AdminProjectsPageSteps(browserService).openPage();
        var adminProjectsPage = adminProjectsPageSteps
                .deleteProjectByName(this.projectName)
                .getPageInstance();

        Assert.assertFalse(adminProjectsPageSteps.isProjectExisted(this.projectName));
        Assert.assertEquals(adminProjectsPage.getSuccessProjectCRUDMessage().getText(),
                "Successfully deleted the project.");
    }
}