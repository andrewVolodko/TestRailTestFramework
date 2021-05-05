package pages.dialogs;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.Element;

public class ConfirmationDeleteDialog extends BasePage {

    @FindBys({@FindBy(css = "[aria-labelledby]"), @FindBy(tagName = "input")})
    public Checkbox deleteCheckbox;

    @FindBys({@FindBy(css = "[aria-labelledby]"), @FindBy(className = "button-ok")})
    public Button okBtn;

    public ConfirmationDeleteDialog(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return By.id("ui-dialog-title-deleteDialog");
    }
}
