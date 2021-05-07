package testData;

import enums.ProjectMode;
import models.ProjectModel;
import org.testng.annotations.DataProvider;
import utils.Randomizer;

public class StaticDataProvider {

    @DataProvider(name = "projectDataProvider")
    public static Object[][] getProjectData() {

        ProjectMode[] modes = ProjectMode.values();
        var data = new ProjectModel[modes.length][];
        for (int i = 0; i < modes.length; i++) {
            data[i] = new ProjectModel[] {
            new ProjectModel(
                    "Project - " + Randomizer.getRandomString(10),
                    "Announcement" + Randomizer.getRandomString(100),
                    i % 2 != 0,
                    modes[i])
                    .setCompleted(i % 2 == 0)
            };
        }
        return data;
    }
}
