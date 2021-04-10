package baseTestTemplates;

import baseEntities.BaseTest;
import core.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTestWithMethodDriverInitialization extends BaseTest {

    @BeforeMethod
    public void setupMethod(){
        this.browserService = new BrowserService();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        this.disposeDriver();
    }

}
