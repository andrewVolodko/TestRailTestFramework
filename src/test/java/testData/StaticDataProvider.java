package testData;

import enums.ProjectMode;
import models.ProjectModel;
import org.testng.annotations.DataProvider;
import utils.Randomizer;

public class StaticDataProvider {

    @DataProvider(name = "projectDataProvider")
    public static Object[][] getProjectData() {
        return new ProjectModel[][]{
                {new ProjectModel(
                        "Project - " + Randomizer.getRandomString(10),
                        "",
                        true,
                        ProjectMode.SINGLE_FOR_ALL_CASES)
                }
        };
    }
}
