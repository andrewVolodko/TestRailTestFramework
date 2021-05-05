package pages.common;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.DropdownMenu;
import wrappers.Element;

public abstract class CommonHeader extends BasePage {

    @FindBy(id = "navigation-dashboard")
    public Button dashboardTabBtn;

    @FindBy(id = "navigation-menu")
    public Element helpDropdownMenuLink;

    @FindBy(id = "helpDropdown")
    public DropdownMenu helpDropdownMenu;

    public CommonHeader(BrowserService browserService, String path) {
        super(browserService, path);
    }
}