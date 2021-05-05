package models;

import enums.ProjectMode;
import utils.Randomizer;

import java.util.Objects;

public class ProjectModel {
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private ProjectMode projectMode;
    private boolean isCompleted;

    public ProjectModel(String name, String announcement, boolean showAnnouncement, ProjectMode projectMode) {
        this.name = name;
        this.announcement = announcement;
        this.showAnnouncement = showAnnouncement;
        this.projectMode = projectMode;
    }

    public static ProjectModel getDefault() {
        return new ProjectModel(
                "Project - " + Randomizer.getRandomString(10),
                "Announcement - " + Randomizer.getRandomString(100),
                true,
                ProjectMode.SINGLE_FOR_ALL_CASES);
    }

    public static ProjectModel getDefault(boolean isCompleted) {
        return getDefault().setIsCompleted(isCompleted);
    }

    public String getName() {
        return name;
    }

    public ProjectModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public ProjectModel setAnnouncement(String announcement) {
        this.announcement = announcement;
        return this;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public ProjectModel setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
        return this;
    }

    public ProjectMode getProjectType() {
        return projectMode;
    }

    public ProjectModel setProjectType(ProjectMode projectMode) {
        this.projectMode = projectMode;
        return this;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    public ProjectModel setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectModel that = (ProjectModel) o;
        return showAnnouncement == that.showAnnouncement && isCompleted == that.isCompleted && Objects.equals(name, that.name) && Objects.equals(announcement, that.announcement) && projectMode == that.projectMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, showAnnouncement, projectMode, isCompleted);
    }
}
