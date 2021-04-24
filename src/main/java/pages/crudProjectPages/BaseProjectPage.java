package pages.crudProjectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.RadioButtonInterface;
import wrappers.UIElement;
import pages.common.CommonHeader;

public abstract class BaseProjectPage extends CommonHeader {

    // Locators
    protected static final By projectTabBy = By.id("projects-tabs-project");
    private static final By projectNameInputBy = By.id("name");
    private static final By projectAnnouncementsInputBy = By.id("announcement");
    private static final By projectShowAnnouncementsCheckboxBy = By.id("show_announcement");
    private static final By projectModeRadioBtnBy = By.cssSelector("[name=suite_mode]");
    private static final By addProjectBtnBy = By.id("accept");

    public BaseProjectPage(BrowserService browserService) {
        super(browserService);
    }

    public UIElement getProjectNameInput() {
        return new UIElement(this.browserService, projectNameInputBy);
    }

    public UIElement getProjectAnnouncementsInput() {
        return new UIElement(this.browserService, projectAnnouncementsInputBy);
    }

    public Checkbox getProjectShowAnnouncementsCheckbox() {
        return new Checkbox(this.browserService, projectShowAnnouncementsCheckboxBy);
    }

    public RadioButtonInterface getProjectModeRadioBtnInterface() {
        return new RadioButtonInterface(this.browserService, projectModeRadioBtnBy);
    }

    public Button getAddProjectBtn() {
        return new Button(this.browserService, addProjectBtnBy);
    }
}
