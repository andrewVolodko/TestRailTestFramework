package wrappers;

import core.BrowserService;
import models.SelectWithDropdownContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SelectWithDropdown implements IElement {
    private final SelectWithDropdownContainer selectWithDropdownContainer;

    public SelectWithDropdown(BrowserService browserService, By selectWithDropdownContainerBy) {
        this.selectWithDropdownContainer =
                getSelectWithDropdownContainer(new Element(browserService, selectWithDropdownContainerBy));
    }

    public SelectWithDropdown(BrowserService browserService, WebElement selectWithDropdownElement) {
        this.selectWithDropdownContainer =
                getSelectWithDropdownContainer(new Element(browserService, selectWithDropdownElement));
    }

    private SelectWithDropdownContainer getSelectWithDropdownContainer(Element selectWithDropdownContainerEl) {
        return new SelectWithDropdownContainer(
                selectWithDropdownContainerEl.findElement(By.tagName("label")),
                selectWithDropdownContainerEl.findElement(By.className("chzn-container")),
                selectWithDropdownContainerEl.findElement(By.tagName("input")),
                selectWithDropdownContainerEl.findAllElements(By.tagName("li"))
        );
    }

    public SelectWithDropdown selectOptionByTextValue(String optionTextValue) {
        this.changeState(true);
        this.selectWithDropdownContainer.getValues()
                .stream()
                .filter(el -> el.getText().equals(optionTextValue))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("No option found with text value provided."))
                .click();

        return this;
    }

    public SelectWithDropdown changeState(boolean makeExpanded) {
        if(this.selectWithDropdownContainer.getSearch().isDisplayed() != makeExpanded)
            this.selectWithDropdownContainer.getSelect().click();

        return this;
    }
}