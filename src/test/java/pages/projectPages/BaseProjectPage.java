package pages.projectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.UIElement;
import pages.common.CommonHeader;

public abstract class BaseProjectPage extends CommonHeader {

    // Locators
    protected static final By projectTabBy = By.id("projects-tabs-project");
    private static final By projectNameInputBy = By.id("name");
    private static final By projectAnnouncementsInputBy = By.id("announcement");
    private static final By projectShowAnnouncementsCheckboxBy = By.id("show_announcement");
    private static final By projectSingleModeRadioBtnBy = By.id("suite_mode_single");
    private static final By projectSingleBaselineModeRadioBtnBy = By.id("suite_mode_single_baseline");
    private static final By projectMultiModeRadioBtnBy = By.id("suite_mode_multi");
    private static final By selectedProjectModeRadioBtnBy = By.cssSelector("[name=suite_mode][checked]");
    private static final By addProjectBtnBy = By.id("accept");

    public BaseProjectPage(BrowserService browserService) {
        super(browserService);
    }

    public UIElement getProjectNameInput() {
        return new UIElement(this.driver, projectNameInputBy);
    }

    public UIElement getProjectAnnouncementsInput() {
        return new UIElement(this.driver, projectAnnouncementsInputBy);
    }

    public Checkbox getProjectShowAnnouncementsCheckbox() {
        return new Checkbox(this.driver, projectShowAnnouncementsCheckboxBy);
    }

    public UIElement getProjectSingleModeRadioBtn() {
        return new UIElement(this.driver, projectSingleModeRadioBtnBy);
    }

    public UIElement getProjectSingleBaselineModeRadioBtn() {
        return new UIElement(this.driver, projectSingleBaselineModeRadioBtnBy); // исправить на RadioBtn обертку
    }

    public UIElement getProjectMultiModeRadioBtn() {
        return new UIElement(this.driver, projectMultiModeRadioBtnBy);
    }


    public UIElement getSelectedProjectMode() {
        return new UIElement(this.driver, selectedProjectModeRadioBtnBy);
    }

    public Button getAddProjectBtn() {
        return new Button(this.driver, addProjectBtnBy);
    }
}
