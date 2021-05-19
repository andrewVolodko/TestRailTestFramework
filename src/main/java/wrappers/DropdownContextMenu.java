package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownContextMenu {
    private final List<Element> dropdownMenuOptions;

    /**
     *
     * @param browserService
     * @param dropdownContextMenuDivElBy - locator of div el that contains all options of dropdown context menu
     *
     */
    public DropdownContextMenu(BrowserService browserService, By dropdownContextMenuDivElBy) {
        var element = browserService.getWait().waitForVisibility(dropdownContextMenuDivElBy);
        this.dropdownMenuOptions = element.findAllElements(By.tagName("a"));
    }

    public DropdownContextMenu(BrowserService browserService, WebElement dropDownContextMenuElement) {
        var element = new Element(browserService, dropDownContextMenuElement);
        this.dropdownMenuOptions = element.findAllElements(By.tagName("a"));
    }

    public Element getOptionByTextValue(String optionTextValue){
        return this.dropdownMenuOptions
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such option found"));
    }

}
