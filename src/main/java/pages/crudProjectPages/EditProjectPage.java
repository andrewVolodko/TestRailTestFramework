package pages.crudProjectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import wrappers.Checkbox;

public class EditProjectPage extends BaseProjectPage {

    // Locators
    private static final String completedProjectCheckboxId = "is_completed";

    @FindBy(id = completedProjectCheckboxId)
    public Checkbox completedProjectCheckbox;

    public EditProjectPage(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return By.id(completedProjectCheckboxId);
    }
}
