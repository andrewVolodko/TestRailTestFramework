package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    protected static final By emailInputBy = By.id("name");
    protected static final By passInputBy = By.id("password");
    protected static final By loginBtnBy = By.id("button_primary");
    protected static final By errorLabelBy = By.className("error-text");
    protected static final By fieldErrorBy = By.className("loginpage-message-image");

    public LoginPage(BrowserService browserService, boolean openByUrl){
        super(browserService, openByUrl);
    }

    @Override
    public LoginPage open(){
        this.driver.get(baseUrl);
        return this;
    }
    @Override
    public By getPageOpenedIndicatorEl() {
        return loginBtnBy;
    }


    public WebElement getEmailInput() {
        return this.driver.findElement(emailInputBy);
    }

    public WebElement getPassInput() {
        return this.driver.findElement(passInputBy);
    }

    public WebElement getLoginBtn() {
        return this.driver.findElement(loginBtnBy);
    }

    public WebElement getErrorLabel() {
        return this.driver.findElement(errorLabelBy);
    }

    public WebElement getFieldError(){
        return this.driver.findElement(fieldErrorBy);
    }
}
