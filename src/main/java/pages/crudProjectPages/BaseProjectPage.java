package pages.crudProjectPages;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.Checkbox;
import wrappers.Element;
import wrappers.RadioButtonInterface;
import pages.common.CommonHeader;

public abstract class BaseProjectPage extends CommonHeader {

    @FindBy(id = "name")
    public Element projectNameInput;

    @FindBy(id = "announcement")
    public Element projectAnnouncementsInput;

    @FindBy(id = "show_announcement")
    public Checkbox projectShowAnnouncementsCheckbox;

    @FindBy(xpath = "//div[@class='row add-project-row']/..")
    public RadioButtonInterface projectModeRadioBtnInterface;

    @FindBy(id = "accept")
    public Button addProjectBtn;

    public BaseProjectPage(BrowserService browserService, String path) {
        super(browserService, path);
    }
}
