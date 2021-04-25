package pages.common;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import wrappers.Button;
import wrappers.DropdownMenu;
import wrappers.UIElement;

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

    public UIElement getHelpDropdownMenuLink() {
        return new UIElement(this.browserService, helpDropdownMenuLinkBy);
    }

    public DropdownMenu getHelpDropdownMenu() {
        return new DropdownMenu(this.browserService, helpDropdownMenuBy);
    }
}