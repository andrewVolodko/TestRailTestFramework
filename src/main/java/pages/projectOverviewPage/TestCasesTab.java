package pages.projectOverviewPage;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.common.CommonHeader;
import wrappers.Button;

public class TestCasesTab extends CommonHeader {

    // Locators
    private static final By pageTitleBy = By.xpath("//div[contains(@class, 'page_title') and contains(text(), 'Test Cases')]");

    @FindBy(id = "sidebar-cases-add")
    public Button sidebarAddTestCaseBtn;

    public TestCasesTab(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return pageTitleBy;
    }
}
