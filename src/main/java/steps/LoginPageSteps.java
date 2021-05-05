package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps extends BaseStep<LoginPage> {

    public LoginPageSteps(BrowserService browserService) {
        super(browserService, LoginPage.class);
    }

    @Override
    public LoginPageSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Login with correct creds")
    public DashboardPageSteps loginWithCorrectCreds(String email, String pass) {
        this.page.emailInput.sendKeys(email);
        this.page.passInput.sendKeys(pass);
        this.page.loginBtn.click();

        return new DashboardPageSteps(this.browserService);
    }

    @Step("Login with incorrect creds")
    public LoginPageSteps loginWithIncorrectCreds(String email, String pass) {
        this.page.emailInput.sendKeys(email);
        this.page.passInput.sendKeys(pass);
        this.page.loginBtn.click();

        return this;
    }
}
