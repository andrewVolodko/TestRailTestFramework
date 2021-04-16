package steps;

import baseEntities.BaseStep;
import core.BrowserService;
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

    public DashboardPageSteps loginWithCorrectCreds(String email, String pass) {
        this.page.getEmailInput().sendKeys(email);
        this.page.getPassInput().sendKeys(pass);
        this.page.getLoginBtn().click();

        return new DashboardPageSteps(this.browserService);
    }

    public LoginPageSteps loginWithIncorrectCreds(String email, String pass) {
        this.page.getEmailInput().sendKeys(email);
        this.page.getPassInput().sendKeys(pass);
        this.page.getLoginBtn().click();

        return this;
    }
}
