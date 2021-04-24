package wrappers;

import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownMenu {
    private final List<UIElement> dropdownMenuOptions;

    public DropdownMenu(BrowserService browserService, By dropdownMenuDivElBy) {
        var element = browserService.getWait().waitForVisibility(dropdownMenuDivElBy);
        this.dropdownMenuOptions = element.findElements(By.tagName("a"))
                .stream()
                .map(el -> new UIElement(browserService, el))
                .collect(Collectors.toList());
    }

    public UIElement getOptionByTextValue(String optionTextValue){
        return this.dropdownMenuOptions
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No such option found"));
    }

}
