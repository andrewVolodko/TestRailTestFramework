package tests;

import apiSteps.ApiSteps;
import baseTestTemplates.BaseTestWithClassDriverInitialization;
import models.ProjectModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.projectOverviewPageSteps.ProjectOverviewTabSteps;
import utils.Listener;

@Listeners(Listener.class)
public class TestCasesCRUDTest extends BaseTestWithClassDriverInitialization {

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void setupClass(String email, String password) {
        ProjectModel projectData = ProjectModel.getDefault();

        int createdProjectId = new ApiSteps(email, password)
                .addProject(projectData).getBody().jsonPath().getInt("id");

        login(email, password)
//        new ProjectOverviewTabSteps(browserService)
                .openProjectTestCasesTabByProjName(projectData.getName())
                .openAddTestCasePage()
                .selectTemplateByOptionValue("Exploratory Session");
    }

    @Test
    public void test() {
        System.out.println();
    }
}
