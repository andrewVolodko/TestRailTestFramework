package pages.projectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BaseProjectPage {
    private static final String PATH = "index.php?/admin/projects/add";

    public AddProjectPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(this.baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorEl() {
        return projectTabBy;
    }
}
