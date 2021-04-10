package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.LoginPage;

public class LoginPageSteps extends BaseStep {
    public LoginPageSteps(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public LoginPage getPageInstance(boolean openByUrl) {
        return new LoginPage(browserService, openByUrl);
    }


    public DashboardPageSteps loginWithCorrectCreds(String email, String pass){
        var loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginBtn().click();

        return new DashboardPageSteps(browserService);
    }
    public LoginPageSteps loginWithInсorrectCreds(String email, String pass){
        var loginPage = new LoginPage(browserService, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassInput().sendKeys(pass);
        loginPage.getLoginBtn().click();

        return new LoginPageSteps(browserService);
    }
}
