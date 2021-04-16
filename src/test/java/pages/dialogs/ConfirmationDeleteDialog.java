package pages.dialogs;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public WebElement getDeleteCheckbox() {
        return getDialogContainer().findElement(deleteCheckboxBy);
    }

    public WebElement getOkBtn() {
        return getDialogContainer().findElement(okBtnBy);
    }

    private WebElement getDialogContainer() {
        return this.driver.findElement(dialogContainerBy);
    }
}
