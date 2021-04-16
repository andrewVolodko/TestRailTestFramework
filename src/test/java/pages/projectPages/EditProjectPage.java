package pages.projectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.UIElement;

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

    public UIElement getCompletedProjectCheckboxBy() {
        return new UIElement(this.driver, completedProjectCheckboxBy);
    }
}
