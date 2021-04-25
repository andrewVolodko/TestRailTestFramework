package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {

    // Locators
    protected static final By emailInputBy = By.id("name");
    protected static final By passInputBy = By.id("password");
    protected static final By loginBtnBy = By.id("button_primary");
    protected static final By errorLabelBy = By.className("error-text");
    protected static final By fieldErrorBy = By.className("loginpage-message-image");

    public LoginPage(BrowserService browserService) {
        super(browserService, "/auth/login");
    }

    @Override
    public By getPageOpenedIndicatorElLocator() {
        return loginBtnBy;
    }


    public UIElement getEmailInput() {
        return new UIElement(this.browserService, emailInputBy);
    }

    public UIElement getPassInput() {
        return new UIElement(this.browserService, passInputBy);
    }

    public Button getLoginBtn() {
        return new Button(this.browserService, loginBtnBy);
    }

    public UIElement getErrorLabel() {
        return new UIElement(this.browserService, errorLabelBy);
    }

    public UIElement getFieldError() {
        return new UIElement(this.browserService, fieldErrorBy);
    }
}
