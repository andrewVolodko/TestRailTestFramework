package wrappers;

import core.BrowserService;
import models.containers.SelectWithDropdownContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SelectWithDropdown {
    private final SelectWithDropdownContainer selectWithDropdownContainer;

    public SelectWithDropdown(BrowserService browserService, By selectWithDropdownContainerBy) {
        var selectWithDropdownContainerEl = new UIElement(browserService, selectWithDropdownContainerBy);
        this.selectWithDropdownContainer = getSelectWithDropdownContainer(selectWithDropdownContainerEl);
    }

    public SelectWithDropdown(UIElement selectWithDropdownContainerEl) {
        this.selectWithDropdownContainer = getSelectWithDropdownContainer(selectWithDropdownContainerEl);
    }

    private SelectWithDropdownContainer getSelectWithDropdownContainer(UIElement selectWithDropdownContainerEl){
        return new SelectWithDropdownContainer(
                selectWithDropdownContainerEl.findElement(By.tagName("label")),
                selectWithDropdownContainerEl.findElement(By.className("chzn-container")),
                selectWithDropdownContainerEl.findElement(By.tagName("input")),
                selectWithDropdownContainerEl.findUIElements(By.tagName("li"))
        );
    }

    public SelectWithDropdown selectOptionByTextValue(String optionTextValue){
        this.selectWithDropdownContainer.getSelect().click();
        this.selectWithDropdownContainer.getValues()
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No option found with text value provided."))
                .click();

        return this;
    }
}
