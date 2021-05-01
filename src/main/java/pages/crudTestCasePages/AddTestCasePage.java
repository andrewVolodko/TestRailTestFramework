package pages.crudTestCasePages;

import core.BrowserService;
import org.openqa.selenium.By;
import pages.common.CommonHeader;
import wrappers.SelectWithDropdown;

public class AddTestCasePage extends CommonHeader {

    // Locators
    private static final By testCaseSettingsSectionBy = By.className("io-container");
    private static final String selectWithDropdownContainerLocator = "//label[contains(text(), '%selectName%')]/..";

    public AddTestCasePage(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return testCaseSettingsSectionBy;
    }

    public SelectWithDropdown getSelectByName(String selectName){
        return new SelectWithDropdown(this.browserService,
                By.xpath(selectWithDropdownContainerLocator.replace("%selectName%", selectName)));
    }
}
