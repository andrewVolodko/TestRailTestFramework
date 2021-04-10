package baseTestTemplates;

import baseEntities.BaseTest;
import core.BrowserService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestWithClassDriverInitialization extends BaseTest {

    @BeforeClass
    public void setupClass(){
        this.browserService = new BrowserService();
        browserService.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDownClass(){
        this.disposeDriver();
    }
}
