package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.Element;

public class LoginPage extends BasePage {

    private final static String loginBtnId = "button_primary";

    @FindBy(id = "name")
    public Element emailInput;

    @FindBy(id = "password")
    public Element passInput;

    @FindBy(id = loginBtnId)
    public Button loginBtn;

    @FindBy(className = "error-text")
    public Element errorLabel;

    @FindBy(className = "loginpage-message-image")
    public Element fieldError;

    public LoginPage(BrowserService browserService) {
        super(browserService, "/auth/login");
    }

    @Override
    public By getPageOpenedIndicatorElLocator() {
        return By.id(loginBtnId);
    }
}
