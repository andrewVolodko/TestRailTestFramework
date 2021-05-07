package models;

import enums.ProjectMode;
import lombok.*;
import lombok.experimental.Accessors;
import utils.Randomizer;

@SuppressWarnings("NullableProblems")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
public class ProjectModel {
    @NonNull private String name;
    @NonNull private String announcement;
    @NonNull private boolean showAnnouncement;
    @NonNull private ProjectMode projectMode;
             private boolean isCompleted;

    public static ProjectModel getDefault() {
        return new ProjectModel(
                "Project - " + Randomizer.getRandomString(10),
                "Announcement - " + Randomizer.getRandomString(100),
                true,
                ProjectMode.SINGLE_FOR_ALL_CASES);
    }

    public static ProjectModel getDefault(boolean isCompleted) {
        return getDefault().setCompleted(isCompleted);
    }
}
