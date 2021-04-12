package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import enums.ProjectMode;
import models.ProjectModel;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.AdminProjectsPageSteps;
import steps.DashboardPageSteps;
import steps.LoginPageSteps;
import utils.Randomizer;

public class ProjectCRUDTest extends BaseTestWithClassDriverInitialization {

    private String projectName;

    private DashboardPageSteps dashboardPageSteps;
    private AdminProjectsPageSteps adminProjectsPageSteps;

    @DataProvider(name = "projectDataProvider")
    public Object[][] getProjectData() {
        return new ProjectModel[][]{
                {new ProjectModel(
                        "Project - " + Randomizer.getRandomString(10),
                        "",
                        true,
                        ProjectMode.MULTIPLE)
                }
        };
    }

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void login(String email, String password) {
        this.dashboardPageSteps = new LoginPageSteps(browserService)
                .openPage()
                .loginWithCorrectCreds(email, password);
    }

    @Test(dataProvider = "projectDataProvider")
    public void addProjectTest(ProjectModel project) {
        this.adminProjectsPageSteps = this.dashboardPageSteps
                .openAddProjectPage()
                .addNewProject(project);

        Assert.assertTrue(
                this.adminProjectsPageSteps
                        .getPageInstance()
                        .getProjectRowByName(project.getName())
                        .getProjectNameLink()
                        .isDisplayed());

        this.projectName = project.getName();
    }

    @Test(dependsOnMethods = "addProjectTest", dataProvider = "projectDataProvider")
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