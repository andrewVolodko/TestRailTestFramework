package pages.projectOverviewPage;

import core.BrowserService;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.Button;

public class TestCasesTab extends CommonHeader {

    // Locators
    private static final By pageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Test Cases')]");
    private static final By sidebarAddTestCaseBtnBy = By.id("sidebar-cases-add");

    public TestCasesTab(BrowserService browserService) {
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
