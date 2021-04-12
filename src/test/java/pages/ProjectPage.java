package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private static final String PATH = "index.php?/admin/projects/add";

    // Locators
    private static final By projectTabBy = By.id("projects-tabs-project");
    private static final By projectNameInputBy = By.id("name");
    private static final By projectAnnouncementsInputBy = By.id("announcement");
    private static final By projectShowAnnouncementsCheckboxBy = By.id("show_announcement");
    private static final By projectSingleModeRadioBtnBy = By.id("suite_mode_single");
    private static final By projectSingleBaselineModeRadioBtnBy = By.id("suite_mode_single_baseline");
    private static final By projectMultiModeRadioBtnBy = By.id("suite_mode_multi");
    private static final By selectedProjectModeRadioBtnBy = By.cssSelector("[name=suite_mode][checked]");
    private static final By addProjectBtnBy = By.id("accept");
    private static final By completedProjectCheckboxBy = By.id("is_completed");

    public ProjectPage(BrowserService browserService) {
        super(browserService);
    }

    @Override
    public void open() {
        this.driver.get(this.baseUrl + PATH);
        super.open();
    }

    @Override
    protected By getPageOpenedIndicatorEl() {
        return projectTabBy;
    }


    public WebElement getProjectNameInput() {
        return this.driver.findElement(projectNameInputBy);
    }

    public WebElement getProjectAnnouncementsInput() {
        return this.driver.findElement(projectAnnouncementsInputBy);
    }

    public WebElement getProjectShowAnnouncementsCheckbox() {
        return this.driver.findElement(projectShowAnnouncementsCheckboxBy);
    }

    public WebElement getProjectSingleModeRadioBtn() {
        return this.driver.findElement(projectSingleModeRadioBtnBy);
    }

    public WebElement getProjectSingleBaselineModeRadioBtn() {
        return this.driver.findElement(projectSingleBaselineModeRadioBtnBy);
    }

    public WebElement getProjectMultiModeRadioBtn() {
        return this.driver.findElement(projectMultiModeRadioBtnBy);
    }

    public WebElement getAddProjectBtn(){
        return this.driver.findElement(addProjectBtnBy);
    }

    public WebElement getSelectedProjectMode(){
        return this.driver.findElement(selectedProjectModeRadioBtnBy);
    }

    public WebElement getCompletedProjectCheckboxBy(){
        return this.driver.findElement(completedProjectCheckboxBy);
    }
}
