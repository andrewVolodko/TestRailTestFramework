package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    @Expose(serialize = false)
    private int id;
    @NonNull @Expose
    private String name;
    @NonNull @Expose
    private String announcement;
    @NonNull @Expose @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;
    @NonNull @Expose @SerializedName(value = "suite_mode")
    private ProjectMode projectMode;
    @Expose(serialize = false) @SerializedName(value = "is_completed")
    private boolean isCompleted;
    @Expose(serialize = false) @SerializedName(value = "completed_on")
    private long completedOn;
    @Expose(serialize = false)
    private String url;

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
