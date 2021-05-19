package pages.common;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.DropdownContextMenu;
import wrappers.Element;

public abstract class CommonHeader extends BasePage {

    // Locators
    private static final By dashboardTabBtnBy = By.id("navigation-dashboard");
    private static final By helpDropdownMenuLinkBy = By.id("navigation-menu");
    private static final By helpDropdownMenuBy = By.id("helpDropdown");

    public CommonHeader(BrowserService browserService, String path) {
        super(browserService, path);
    }

    public Button getDashboardTabBtn() {
        return new Button(this.browserService, dashboardTabBtnBy);
    }

    public Element getHelpDropdownMenuLink() {
        return new Element(this.browserService, helpDropdownMenuLinkBy);
    }

    public DropdownContextMenu getHelpDropdownMenu() {
        return new DropdownContextMenu(this.browserService, helpDropdownMenuBy);
    }
}