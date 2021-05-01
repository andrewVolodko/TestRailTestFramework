package tests;

import baseTestTemplates.BaseTestWithClassDriverInitialization;
import models.ProjectModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCasesCRUDTest extends BaseTestWithClassDriverInitialization {

    @BeforeClass
    @Parameters({"validEmail", "validPassword"})
    public void setupClass(String email, String password) {
        ProjectModel projectData = ProjectModel.getDefault();

        login(email, password)
                .openAddProjectPage()
                .addNewProject(projectData)
                .goToDashboardTab()
                .openProjectTestCasesTabByProjName(projectData.getName())
                .openAddTestCasePage()
                .selectTemplateByOptionValue("Exploratory Session");

    }

    @Test
    public void test() {
        System.out.println();
    }
}
