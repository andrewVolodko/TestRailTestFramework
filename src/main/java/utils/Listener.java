package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener  implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){
        Object curClass = result.getInstance();
        WebDriver driver = ((BaseTest)curClass).browserService.getDriver();
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(screenshot);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }
}
