package pages.projectDetailsPage;

import core.BrowserService;
import org.openqa.selenium.By;

public class ProjectOverviewTab extends ProjectDetailsPageHeader {
    private static final String PATH = "/projects/overview/%d";
    private static final By activityChartBy = By.id("activityChart");

    public ProjectOverviewTab(BrowserService browserService) {
        super(browserService, null);
    }

    public ProjectOverviewTab openProjectOverviewPageByProjId(int projectId){
        this.browserService.getDriver().get(this.baseUrl + String.format(PATH, projectId));
        return this;
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return activityChartBy;
    }
}
