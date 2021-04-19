package pages.projectPages;

import core.BrowserService;
import org.openqa.selenium.By;

public class AddProjectPage extends BaseProjectPage {
    private static final String PATH = "/admin/projects/add";

    public AddProjectPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(this.baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return projectTabBy;
    }
}
