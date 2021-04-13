package testData;

import enums.ProjectMode;
import models.ProjectModel;
import org.testng.annotations.DataProvider;
import utils.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class StaticDataProvider {

    @DataProvider(name = "projectDataProvider")
    public static Object[][] getProjectData() {


        List<ProjectModel> projectsData = new ArrayList<>();
        ProjectMode[] modes = ProjectMode.values();
        var data = new ProjectModel[modes.length][];
        for (int i = 0; i < modes.length; i++) {
            data[i] = new ProjectModel[] {
            new ProjectModel(
                    "Project - " + Randomizer.getRandomString(10),
                    "Announcement" + Randomizer.getRandomString(100),
                    i % 2 != 0,
                    modes[i])
                    .setIsCompleted(i % 2 == 0)
            };
        }
        return data;
//        var test1 = projectsData.toArray(ProjectModel[]::new);
//        var test = new ProjectModel[][]{
//                {projectsData.get(0)},
//                {projectsData.get(1)},
//                {projectsData.get(2)}
////                projectsData.toArray(ProjectModel[]::new)
//        };
//        var data = new ProjectModel[3][];
//        for (int i = 0; i < data.length; i++) {
//            data[i] = new ProjectModel[]{projectsData.get(i)};
//        }
//        Object[][] test = projectsData.toArray(Object[][]::new);
    }
}
