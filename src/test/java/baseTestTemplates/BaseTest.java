package baseTestTemplates;

import core.BrowserService;
import core.PropertyReader;
import steps.DashboardPageSteps;
import steps.LoginPageSteps;

public abstract class BaseTest {
    protected BrowserService browserService;
    protected PropertyReader propertyReader;

    protected void disposeDriver() {
        this.browserService.getDriver().close();
        this.browserService.getDriver().quit();
        this.browserService = null;
    }

    protected DashboardPageSteps login(String email, String password) {
        return new LoginPageSteps(browserService)
                .openPage()
                .loginWithCorrectCreds(email, password);
    }
}
