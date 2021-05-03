package tests;

import baseTestTemplates.BaseTestWithMethodDriverInitialization;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import steps.LoginPageSteps;
import utils.Listener;

@Listeners(Listener.class)
public class LoginTest extends BaseTestWithMethodDriverInitialization {

    private LoginPageSteps loginPageSteps;

    @BeforeMethod
    public void initializeLoginSteps() {
        this.loginPageSteps = new LoginPageSteps(browserService).openPage();
    }

    @Test(description = "Login Test")
    @Description("Verification with valid creds")
    @Parameters({"validEmail", "validPassword"})
    public void validCredsLoginTest(String email, String password) {
        this.loginPageSteps.loginWithCorrectCreds(email, password);

        Assert.assertEquals(browserService.getDriver().getTitle(), "All Projects - TestRail");
    }

    @Test(description = "Login Test")
    @Description("Verification with invalid creds")
    @Parameters({"invalidEmail", "invalidPassword"})
    public void invalidCredsLoginTest(String email, String password) {
        var loginPage = this.loginPageSteps
                .loginWithIncorrectCreds(email, password)
                .getPageInstance();

        Assert.assertEquals(loginPage.getErrorLabel().getText(),
                "Email/Login or Password is incorrect. Please try again.");
    }

    @Test(description = "Login Test")
    @Description("Verification with valid email and omitted password")
    @Parameters("validEmail")
    public void provideOnlyEmailLoginTest(String email) {
        var loginPage = this.loginPageSteps.getPageInstance();
        loginPage.emailInput.sendKeys(email);
        loginPage.getLoginBtn().click();

        Assert.assertEquals(loginPage.getFieldError().getText(), "Password is required.");
    }
}
