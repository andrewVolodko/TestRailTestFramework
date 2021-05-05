package wrappers;

import core.BrowserService;
import models.SelectWithDropdownContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class SelectWithDropdown {
    private final SelectWithDropdownContainer selectWithDropdownContainer;

    public SelectWithDropdown(BrowserService browserService, By selectWithDropdownContainerBy) {
        var selectWithDropdownContainerEl = new Element(browserService, selectWithDropdownContainerBy);
        this.selectWithDropdownContainer = getSelectWithDropdownContainer(selectWithDropdownContainerEl);
    }

    public SelectWithDropdown(Element selectWithDropdownContainerEl) {
        this.selectWithDropdownContainer = getSelectWithDropdownContainer(selectWithDropdownContainerEl);
    }

    private SelectWithDropdownContainer getSelectWithDropdownContainer(Element selectWithDropdownContainerEl){
        return new SelectWithDropdownContainer(
                selectWithDropdownContainerEl.findElement(By.tagName("label")),
                selectWithDropdownContainerEl.findElement(By.className("chzn-container")),
                selectWithDropdownContainerEl.findElement(By.tagName("input")),
                selectWithDropdownContainerEl.findAllElements(By.tagName("li"))
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
