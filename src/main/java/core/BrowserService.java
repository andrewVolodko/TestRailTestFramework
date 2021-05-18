package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Waiter;

import java.util.NoSuchElementException;

public class BrowserService {
    private final WebDriver driver;

    public BrowserService() {

        switch (PropertyReader.getBrowserName().toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                this.driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                this.driver = new FirefoxDriver();
            }
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












