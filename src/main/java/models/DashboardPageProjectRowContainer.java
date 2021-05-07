package models;

import enums.ProjectSummaryLink;
import wrappers.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class DashboardPageProjectRowContainer {
    @Getter private final Element projectNameLink;
    private final List<Element> projectSummaryLinks;

    public Element getProjectSummaryLink(ProjectSummaryLink projectSummaryLink) {
        return projectSummaryLinks.get(projectSummaryLink.getValue());
    }
}
