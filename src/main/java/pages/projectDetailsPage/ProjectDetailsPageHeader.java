package pages.projectDetailsPage;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Element;

public abstract class ProjectDetailsPageHeader extends BasePage {

    // Locators
    private static final By testCasesTabBy = By.id("navigation-suites");

    public ProjectDetailsPageHeader(BrowserService browserService, String path) {
        super(browserService, path);
    }

    public Element getTestCasesTab(){
        return new Element(this.browserService, testCasesTabBy);
    }
}
