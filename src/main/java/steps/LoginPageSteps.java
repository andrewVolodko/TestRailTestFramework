package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps extends BaseStep<LoginPage> {

    public LoginPageSteps(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    public LoginPageSteps openPage() {
        this.page.open();
        return this;
    }

    @Step("Login with correct creds")
    public DashboardPageSteps loginWithCorrectCreds(String email, String pass) {
        this.page.getEmailInput().sendKeys(email);
        this.page.getPassInput().sendKeys(pass);
        this.page.getLoginBtn().click();

        return new DashboardPageSteps(this.browserService, false);
    }

    @Step("Login with incorrect creds")
    public LoginPageSteps loginWithIncorrectCreds(String email, String pass) {
        this.page.getEmailInput().sendKeys(email);
        this.page.getPassInput().sendKeys(pass);
        this.page.getLoginBtn().click();

        return this;
    }
}
