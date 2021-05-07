package pages.crudProjectPages;

import core.BrowserService;
import org.openqa.selenium.By;

public class AddProjectPage extends BaseProjectPage {

    public AddProjectPage(BrowserService browserService) {
        super(browserService, "/admin/projects/add");
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return By.id("projects-tabs-project");
    }
}
