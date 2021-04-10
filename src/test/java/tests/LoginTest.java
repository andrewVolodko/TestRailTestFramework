package tests;

import baseTestTemplates.BaseTestWithMethodDriverInitialization;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.LoginPageSteps;

public class LoginTest extends BaseTestWithMethodDriverInitialization {

    private LoginPageSteps loginPageSteps;

    @BeforeMethod
    public void initializeLoginSteps() {
        this.loginPageSteps = new LoginPageSteps(browserService);
    }

    @Test
    @Parameters({"validEmail", "validPassword"})
    public void validCredsLoginTest(String email, String password) {
        this.loginPageSteps.loginWithCorrectCreds(email, password);

        Assert.assertEquals(browserService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test
    @Parameters({"invalidEmail", "invalidPassword"})
    public void invalidCredsLoginTest(String email, String password) {
        var loginPage = this.loginPageSteps
                        .loginWithInсorrectCreds(email, password)
                        .getPageInstance(false);

        Assert.assertEquals(loginPage.getErrorLabel().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test
    @Parameters("validEmail")
    public void provideOnlyEmailLoginTest(String email) {
        var loginPage = this.loginPageSteps.getPageInstance(true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getLoginBtn().click();

        Assert.assertEquals(loginPage.getFieldError().getText(), "Password is required.");
    }
}
