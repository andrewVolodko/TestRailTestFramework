package models.containers;

import enums.ProjectSummaryLink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import wrappers.UIElement;

import java.util.List;

@AllArgsConstructor
public class DashboardPageProjectRowContainer {
    @Getter private final UIElement projectNameLink;
    private final List<UIElement> projectSummaryLinks;

    public UIElement getProjectSummaryLink(ProjectSummaryLink projectSummaryLink) {
        return projectSummaryLinks.get(projectSummaryLink.getValue());
    }
}
