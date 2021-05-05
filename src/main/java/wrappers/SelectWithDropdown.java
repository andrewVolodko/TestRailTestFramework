package wrappers;

import core.BrowserService;
import models.SelectWithDropdownContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SelectWithDropdown {
    private final SelectWithDropdownContainer selectWithDropdownContainer;

    public SelectWithDropdown(BrowserService browserService, By selectWithDropdownContainerBy) {
        this(browserService, browserService.getDriver().findElement(selectWithDropdownContainerBy));
    }

    public SelectWithDropdown(BrowserService browserService, WebElement selectWithDropdownElement){
        this.selectWithDropdownContainer =
                getSelectWithDropdownContainer(new Element(browserService, selectWithDropdownElement));
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
