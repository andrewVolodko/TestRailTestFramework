package pages.projectDetailsPage;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.UIElement;

public abstract class ProjectDetailsPageHeader extends BasePage {

    // Locators
    private static final By testCasesTabBy = By.id("navigation-suites");

    public ProjectDetailsPageHeader(BrowserService browserService, String path) {
        super(browserService, path);
    }

    public UIElement getTestCasesTab(){
        return new UIElement(this.browserService, testCasesTabBy);
    }
}
