package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;

public class DropdownMenu {
    private final UIElement element;

    public DropdownMenu(BrowserService browserService, By dropdownMenuDivElBy) {
        var element = browserService.getWait().waitForVisibility(dropdownMenuDivElBy);
        this.element = new UIElement(browserService, element);
    }


}
