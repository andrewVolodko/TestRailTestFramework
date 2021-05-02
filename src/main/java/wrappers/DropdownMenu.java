package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class DropdownMenu {
    private final List<UIElement> dropdownMenuOptions;

    public DropdownMenu(BrowserService browserService, By dropdownMenuDivElBy) {
        var element = browserService.getWait().waitForVisibility(dropdownMenuDivElBy);
        this.dropdownMenuOptions = element.findUIElements(By.tagName("a"));
    }

    public UIElement getOptionByTextValue(String optionTextValue){
        return this.dropdownMenuOptions
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such option found"));
    }

}
