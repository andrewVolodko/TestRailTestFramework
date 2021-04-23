package models;

import enums.ProjectSummaryLink;
import wrappers.UIElement;

import java.util.List;

public class DashboardPageProjectRowContainer {
    private final UIElement projectNameLink;
    private final List<UIElement> projectSummaryLinks;

    public DashboardPageProjectRowContainer(UIElement projectNameLink, List<UIElement> projectSummaryLinks) {
        this.projectNameLink = projectNameLink;
        this.projectSummaryLinks = projectSummaryLinks;
    }

    public UIElement getProjectNameLink() {
        return projectNameLink;
    }

    public UIElement getProjectSummaryLink(ProjectSummaryLink projectSummaryLink) {
        return projectSummaryLinks.get(projectSummaryLink.getValue());
    }
}
