package pages.dialogs;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
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
    protected By getPageOpenedIndicatorEl() {
        return title;
    }

    public UIElement getDeleteCheckbox() {
        return getDialogContainer().findElement(deleteCheckboxBy);
    }

    public UIElement getOkBtn() {
        return getDialogContainer().findElement(okBtnBy);
    }

    private UIElement getDialogContainer() {
        return new UIElement(this.driver, dialogContainerBy);
    }
}
