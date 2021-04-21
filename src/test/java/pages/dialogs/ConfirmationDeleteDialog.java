package pages.dialogs;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.UIElement;

public class ConfirmationDeleteDialog extends BasePage {

    // Locators
    private static final By dialogContainerBy = By.cssSelector("[aria-labelledby]");
    private static final By title = By.id("ui-dialog-title-deleteDialog");
    private static final By deleteCheckboxBy = By.tagName("input");
    private static final By okBtnBy = By.className("button-ok");

    public ConfirmationDeleteDialog(BrowserService browserService) {
        super(browserService);
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

    private UIElement getDialogContainer() {
        return new UIElement(this.driver, dialogContainerBy);
    }
}
