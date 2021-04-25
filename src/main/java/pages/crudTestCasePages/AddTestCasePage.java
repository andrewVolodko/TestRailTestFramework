package pages.crudTestCasePages;

import core.BrowserService;
import org.openqa.selenium.By;
import pages.common.CommonHeader;

public class AddTestCasePage extends CommonHeader {

    // Locators
    private static final By testCaseSettingsSectionBy = By.className("io-container");

    public AddTestCasePage(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return testCaseSettingsSectionBy;
    }
}
