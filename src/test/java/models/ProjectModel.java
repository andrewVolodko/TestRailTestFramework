package models;


import enums.ProjectType;

public class ProjectModel {
    private String name;
    private String announcement;
    private boolean showAnnouncement;
    private ProjectType projectType;

    public ProjectModel(String name, String announcement, boolean showAnnouncement, ProjectType projectType) {
        this.name = name;
        this.announcement = announcement;
        this.showAnnouncement = showAnnouncement;
        this.projectType = projectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }
}
