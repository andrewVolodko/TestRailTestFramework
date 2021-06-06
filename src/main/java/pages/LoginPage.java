package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Element;

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


    public Element getEmailInput() {
        return new Element(this.browserService, emailInputBy);
    }

    public Element getPassInput() {
        return new Element(this.browserService, passInputBy);
    }

    public Button getLoginBtn() {
        return new Button(this.browserService, loginBtnBy);
    }

    public Element getErrorLabel() {
        return new Element(this.browserService, errorLabelBy);
    }

    public Element getFieldError() {
        return new Element(this.browserService, fieldErrorBy);
    }
}
