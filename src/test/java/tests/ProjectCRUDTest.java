package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import models.ProjectModel;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.AdminProjectsPageSteps;
import steps.DashboardPageSteps;
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
    public void loginBeforeTests(String email, String password) {
        this.dashboardPageSteps = login(email, password);
    }

    @Test
    public void addProjectTest() {
        this.adminProjectsPageSteps = this.dashboardPageSteps // на странице дашборд
                .openAddProjectPage() // открываем страницу add proj - мы на этой странице
                .addNewProject(this.curProjectData); // добавляем проект и сабмитаем

        var createdProjectNameLink = this.adminProjectsPageSteps
                .getPageInstance()
                .getProjectRowByName(this.curProjectData.getName())
                .getProjectNameLink();

        Assert.assertTrue(createdProjectNameLink.isDisplayed());
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void editProjectTest() {
        var editedProject = this.adminProjectsPageSteps
                .openEditProjectPageByName(this.curProjectData.getName())
                .editProject(this.curProjectData.setName(Randomizer.getRandomString(10)))
                .openEditProjectPageByName(this.curProjectData.getName())
                .getProjectData();

        Assert.assertEquals(editedProject, this.curProjectData);
    }

    @Test(dependsOnMethods = "editProjectTest")
    public void deleteProjectTest() {
        var adminProjectsPage = this.adminProjectsPageSteps
                .openPage()
                .deleteProjectByName(this.curProjectData.getName())
                .getPageInstance();

        Assert.assertFalse(this.adminProjectsPageSteps.isProjectExisted(this.curProjectData.getName()));
        Assert.assertEquals(adminProjectsPage.getSuccessProjectCRUDMessage().getText(),
                "Successfully deleted the project.");
    }
}