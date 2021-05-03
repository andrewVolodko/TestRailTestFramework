package models;

import enums.ProjectSummaryLink;
import wrappers.Element;

import java.util.List;

public class DashboardPageProjectRowContainer {
    private final Element projectNameLink;
    private final List<Element> projectSummaryLinks;

    public DashboardPageProjectRowContainer(Element projectNameLink, List<Element> projectSummaryLinks) {
        this.projectNameLink = projectNameLink;
        this.projectSummaryLinks = projectSummaryLinks;
    }

    public Element getProjectNameLink() {
        return projectNameLink;
    }

    public Element getProjectSummaryLink(ProjectSummaryLink projectSummaryLink) {
        return projectSummaryLinks.get(projectSummaryLink.getValue());
    }
}
