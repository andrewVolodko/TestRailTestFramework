package pages.dialogs;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.Element;

public class ConfirmationDeleteDialog extends BasePage {

    // Locators
    private static final By dialogContainerBy = By.cssSelector("[aria-labelledby]");
    private static final By title = By.id("ui-dialog-title-deleteDialog");
    private static final By deleteCheckboxBy = By.tagName("input");
    private static final By okBtnBy = By.className("button-ok");

    public ConfirmationDeleteDialog(BrowserService browserService) {
        super(browserService, null);
    }

    @Override
    protected By getPageOpenedIndicatorElLocator() {
        return title;
    }

    public Checkbox getDeleteCheckbox() {
        return getDialogContainer().findElement(deleteCheckboxBy).castToCheckbox();
    }

    public Button getOkBtn() {
        return getDialogContainer().findElement(okBtnBy).castToButton();
    }

    private Element getDialogContainer() {
        return new Element(this.browserService, dialogContainerBy);
    }
}
