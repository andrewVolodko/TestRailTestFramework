package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private static final String PATH = "index.php?/admin/projects/add";

    // Locators
    private static final By projectTabBy = By.id("projects-tabs-project");
    private static final By projectNameInputBy = By.id("name");
    private static final By projectAnnouncementsInputBy = By.id("announcement");
    private static final By projectShowAnnouncementsCheckboxBy = By.id("show_announcement");
    private static final By projectSingleModeRadioBtnBy = By.id("suite_mode_single");
    private static final By projectSingleBaselineModeRadioBtnBy = By.id("suite_mode_single_baseline");
    private static final By projectMultiModeRadioBtnBy = By.id("suite_mode_multi");
    private static final By addProjectBtnBy = By.id("accept");

    public AddProjectPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorEl() {
        return projectTabBy;
    }

    public WebElement getProjectNameInput() {
        return driver.findElement(projectNameInputBy);
    }

    public WebElement getProjectAnnouncementsInput() {
        return driver.findElement(projectAnnouncementsInputBy);
    }

    public WebElement getProjectShowAnnouncementsCheckbox() {
        return driver.findElement(projectShowAnnouncementsCheckboxBy);
    }

    public WebElement getProjectSingleModeRadioBtn() {
        return driver.findElement(projectSingleModeRadioBtnBy);
    }

    public WebElement getProjectSingleBaselineModeRadioBtn() {
        return driver.findElement(projectSingleBaselineModeRadioBtnBy);
    }

    public WebElement getProjectMultiModeRadioBtn() {
        return driver.findElement(projectMultiModeRadioBtnBy);
    }

    public WebElement getAddProjectBtn(){
        return driver.findElement(addProjectBtnBy);
    }
}
