package pages.projectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditProjectPage extends BaseProjectPage {

    // Locators
    private static final By completedProjectCheckboxBy = By.id("is_completed");

    public EditProjectPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    protected By getPageOpenedIndicatorEl() {
        return completedProjectCheckboxBy;
    }

    public WebElement getCompletedProjectCheckboxBy() {
        return this.driver.findElement(completedProjectCheckboxBy);
    }
}
