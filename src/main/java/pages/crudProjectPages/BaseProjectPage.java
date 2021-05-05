package pages.crudProjectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.Element;
import wrappers.RadioButtonInterface;
import pages.common.CommonHeader;

public abstract class BaseProjectPage extends CommonHeader {

    // Locators
    protected static final By projectTabBy = By.id("projects-tabs-project");
    private static final By projectNameInputBy = By.id("name");
    private static final By projectAnnouncementsInputBy = By.id("announcement");
    private static final By projectShowAnnouncementsCheckboxBy = By.id("show_announcement");
    private static final By projectModeRadioButtonsContainerBy = By.xpath("//div[@class='row add-project-row']/..");
    private static final By addProjectBtnBy = By.id("accept");

    public BaseProjectPage(BrowserService browserService, String path) {
        super(browserService, path);
    }

    public Element getProjectNameInput() {
        return new Element(this.browserService, projectNameInputBy);
    }

    public Element getProjectAnnouncementsInput() {
        return new Element(this.browserService, projectAnnouncementsInputBy);
    }

    public Checkbox getProjectShowAnnouncementsCheckbox() {
        return new Checkbox(this.browserService, projectShowAnnouncementsCheckboxBy);
    }

    public RadioButtonInterface getProjectModeRadioBtnInterface() {
        return new RadioButtonInterface(this.browserService, projectModeRadioButtonsContainerBy);
    }

    public Button getAddProjectBtn() {
        return new Button(this.browserService, addProjectBtnBy);
    }
}
