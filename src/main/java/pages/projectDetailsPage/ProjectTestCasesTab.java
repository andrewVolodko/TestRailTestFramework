package pages.projectDetailsPage;

import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;

public class ProjectTestCasesTab extends ProjectDetailsPageHeader {

    // Locators
    private static final By pageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Test Cases')]");
    private static final By sidebarAddTestCaseBtnBy = By.id("sidebar-cases-add");

    public ProjectTestCasesTab(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return pageTitleBy;
    }

    public Button getSidebarAddTestCaseButton(){
        return new Button(this.browserService, sidebarAddTestCaseBtnBy);
    }
}
