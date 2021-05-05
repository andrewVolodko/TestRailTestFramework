package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropdownMenu implements IElement {
    private final List<Element> dropdownMenuOptions;

    public DropdownMenu(BrowserService browserService, By dropdownMenuDivElBy) {
        var element = browserService.getWait().waitForVisibility(dropdownMenuDivElBy);
        this.dropdownMenuOptions = element.findAllElements(By.tagName("a"));
    }

    public DropdownMenu(BrowserService browserService, WebElement dropDownElement) {
        var element = new Element(browserService, dropDownElement);
        this.dropdownMenuOptions = element.findAllElements(By.tagName("a"));
    }

    public Element getOptionByTextValue(String optionTextValue) {
        return this.dropdownMenuOptions
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such option found"));
    }

}
