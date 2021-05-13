package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import enums.ProjectMode;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import utils.Randomizer;

@Data
@Accessors(chain = true)
public class ProjectModel {
    @Expose(serialize = false)
    private int id;
    @NotNull @Expose
    private String name;
    @Expose
    private String announcement;
    @Expose @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;
    @Expose @SerializedName(value = "suite_mode")
    private int projectMode;
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

    public ProjectModel(String name, String announcement, boolean showAnnouncement, ProjectMode projectMode) {
        this.name = name;
        this.announcement = announcement;
        this.showAnnouncement = showAnnouncement;
        this.projectMode = projectMode.getValue();
    }

    public static ProjectModel getDefault(boolean isCompleted) {
        return getDefault().setCompleted(isCompleted);
    }

    public ProjectModel setProjectMode(ProjectMode projectMode){
        this.projectMode = projectMode.getValue();
        return this;
    }
}
