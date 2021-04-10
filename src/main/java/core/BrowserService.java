package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Waiter;

import java.util.NoSuchElementException;

public class BrowserService {
    private WebDriver driver;

    public BrowserService() {
        PropertyReader propertyReader = new PropertyReader();

        DriverManagerType driverManagerType;
        switch (propertyReader.getBrowserName().toLowerCase()) {
            case "chrome" -> {
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
            }
            case "ie" -> driverManagerType = DriverManagerType.IEXPLORER;
            case "safari" -> driverManagerType = DriverManagerType.SAFARI;
            case "remote" -> driverManagerType = DriverManagerType.SELENIUM_SERVER_STANDALONE;
            case "edge" -> driverManagerType = DriverManagerType.EDGE;
            default -> throw new NoSuchElementException();
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public Waiter getWait(){
        return new Waiter(this);
    }
    public Waiter getWait(int timeout){
        return new Waiter(this, timeout);
    }
}












