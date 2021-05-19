package models.containers;

import enums.ProjectSummaryLink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.Element;

import java.util.List;

@AllArgsConstructor
public class DashboardPageProjectRowContainer {
    @Getter private final Element projectNameLink;
    private final List<Element> projectSummaryLinks;

    public Element getProjectSummaryLink(ProjectSummaryLink projectSummaryLink) {
        return projectSummaryLinks.get(projectSummaryLink.getValue());
    }
}
